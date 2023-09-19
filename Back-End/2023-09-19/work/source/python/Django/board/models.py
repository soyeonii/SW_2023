from django.db import models
from django.utils.timezone import now

# Create your models here.
class Notice(models.Model):
    title = models.CharField(max_length=100)
    content = models.CharField(max_length=2000)
    write_date = models.DateTimeField(default=now, editable=False)
    write_id = models.CharField(max_length=50)

    def __str__(self):
        return self.title