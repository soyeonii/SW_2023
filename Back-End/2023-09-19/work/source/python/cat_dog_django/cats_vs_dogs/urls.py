from django.urls import path
from . import views

app_name = 'catndog'

urlpatterns = [
    path('predict/', views.catordog, name='image')
]