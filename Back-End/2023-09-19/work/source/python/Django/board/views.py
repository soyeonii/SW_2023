from django.shortcuts import render, redirect, get_object_or_404
from .models import Notice
from django.urls import reverse
from django.utils import timezone

# Create your views here.
def index(request):
    article_list = Notice.objects.all().order_by('-write_date') # -? desc
    context = {'article_list': article_list}
    return render(request, 'board/index.html', context)

def write_article(request):
    return render(request, 'board/write.html')

def add(request):
    notice = Notice()
    notice.title = request.POST['i_title']
    notice.content = request.POST['i_content']
    notice.write_id = 'Hi'
    notice.save()
    return redirect(reverse('board:index'))

def view(request, article_id):
    notice = get_object_or_404(Notice, pk=article_id)
    return render(request, 'board/view.html', {'article': notice})

def update(request, article_id):
    notice = Notice.objects.get(id=article_id)  # 업데이트는 글이 없는 경우가 없음
    if request.method == 'POST':
        notice.title = request.POST['title']
        notice.content = request.POST['content']
        notice.write_date = timezone.datetime.now()
        notice.save()
        return redirect(reverse('board:view_article', args=(article_id,)))
    else:
        return render(request, 'board/view.html', {'article': notice})
    
def delete(request, article_id):
    notice = Notice.objects.get(id=article_id)
    notice.delete()
    return redirect(reverse('board:index'))