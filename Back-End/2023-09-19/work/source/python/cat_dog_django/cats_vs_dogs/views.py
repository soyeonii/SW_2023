from django.shortcuts import render
from tensorflow.keras.preprocessing import image
from tensorflow.keras import models
import numpy as np
from django.http import JsonResponse
from django.views.decorators.csrf import csrf_exempt
from django.conf import settings

# Create your views here.
@csrf_exempt
def catordog(request):
    img_path = request.POST['id']
    img = image.load_img(img_path, target_size=(150, 150))

    img_array = image.img_to_array(img).astype(float) / 255
    img_batch = np.expand_dims(img_array, axis=0)

    # model = models.load_model('C:/work/source/python/tf/model/dogs-vs-cats_2.hdf5')
    # prediction = model.predict(img_batch)
    # prediction = str(prediction.flatten()[0])
    prediction = str(settings.MODEL.predict(img_batch).flatten()[0])
    print('prediction =>', prediction)
    
    return JsonResponse({'result': prediction})