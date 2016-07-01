# Django [^1]

Django is a high-level Python Web framework that encourages rapid development and clean, pragmatic design. Built by experienced developers, it takes care of much of the hassle of Web development, so you can focus on writing your app without needing to reinvent the wheel. It’s free and open source.

**Project Folder Structure**

```
project_folder/
├── your_project_name/
│   ├── your_project_name/
│   │   ├── static/
│   │   ├── models.py
│   │   ├── serializers.py
│   │   ├── settings.py
│   │   ├── urls.py
│   │   └── views.py
└   └── manage.py
```

# Create (and use) REST API in 5 (+1) steps [^1] [^2]

## Step 1: Install dependencies

```bash
pip install django
pip install djangorestframework
pip install markdown             # Markdown support for the browsable API.
pip install django-filter        # Filtering support
pip install django-cors-headers  # CORS support
```

## Step 2: Create project

```
django-admin startproject your_project_name
```


## Step 3: Config apps [^3]

Add 'your_project_name', 'rest_framework' to your INSTALLED_APPS setting in `your_project_name/settings.py` file

```
INSTALLED_APPS = (
    ...
    'your_project_name'
    'rest_framework',
)
```

## Step 4: `Model`, `View`, `Route` [^6]

### Step 4.1: Create model and serializer

You can go to [Django: Model field reference page](https://docs.djangoproject.com/en/1.9/ref/models/fields/#model-field-types) for more fields.

#### Step 4.1.1: Create `Task` class in `your_project_name/models.py` file

```
from django.db import models

class Task(models.Model):
    content = models.CharField(max_length=30)
    status = models.CharField(max_length=30)
```

#### Step 4.1.2: Create `TaskSerializer` class in `your_project_name/serializers.py` file

```
from your_project_name.models import Task
from rest_framework import serializers

class TaskSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Task
        fields = ('id', 'content', 'status')
```


#### Step 4.1.3: Create table in database [^4]

```bash
python manage.py syncdb
```

With `django 1.9`

```bash
python manage.py makemigrations your_project_name
python manage.py migrate
```


### Step 4.2: Create `TaskViewSet` class in `your_project_name/views.py` file

```python
from your_project_name.models import Task
from your_project_name.serializers import TaskSerializer
from rest_framework import viewsets

class TaskViewSet(viewsets.ModelViewSet):
    queryset = Task.objects.all()
    serializer_class = TaskSerializer
```

### Step 4.3: Config `route` [^5]

Change `your_project_name/urls.py` file

```python
from django.conf.urls import include, url
from django.contrib import admin
from rest_framework import routers
from your_project_name.views import TaskViewSet

router = routers.DefaultRouter()
router.register(r'api/tasks', TaskViewSet)
admin.autodiscover()

urlpatterns = [
    url(r'^admin/', include(admin.site.urls)),
    url(r'^', include(router.urls)),
    url(r'^api-auth/', include('rest_framework.urls', namespace='rest_framework'))
]
```

## Step 5: Run Server

```bash
python manage.py runserver
```

## Step 6. Use API

#### Step 6.1: Create a new task

```bash
curl -i -X POST -H "Content-Type:application/json" http://localhost:8000/api/tasks -d '{
  "content": "a",
  "status": "INIT"
}'
```

#### Step 6.2: List all tasks

```bash
curl http://localhost:8000/api/tasks
```

#### Step 6.3: Get detail of task 1

```bash
curl http://localhost:8000/api/tasks/1
```

#### Step 6.4: Delete task 1

```bash
curl -i -X DELETE http://localhost:8000/api/tasks/1
```

## Step 7: CORS

Known Error: `No 'Access-Control-Allow-Origin' header is present on the requested resource. Origin 'null' is therefore not allowed access.`

### Step 7.1: Install `corsheader` app

Add module `corsheaders` to `your_project_name/settings.py`

```bash
INSTALLED_APPS = (
    ...
    'corsheaders',
    ...
)
```

### Step 7.2 Add middleware classes

Add middleware_classes to `your_project_name/settings.py`

```bash
MIDDLEWARE_CLASSES = (
    ...
    'corsheaders.middleware.CorsMiddleware',
    'django.middleware.common.CommonMiddleware',
    ...
)
```

### Step 7.3 Configuration CORS Setting

**Option 1**: Allow All

Add this line to `your_project_name/settings.py`

```bash
CORS_ORIGIN_ALLOW_ALL: True
```

## Step 8: https

You can use `https://github.com/teddziuba/django-sslserver`

### Unicode

```python
REST_FRAMEWORK = {
    'DEFAULT_RENDERER_CLASSES': (
        'rest_framework.renderers.JSONRenderer',
        'rest_framework.renderers.BrowsableAPIRenderer',
    )
}
```

## Step 9: Paging

Add this module setting to `your_project_name/settings.py`

```python

REST_FRAMEWORK = {
    'DEFAULT_PAGINATION_CLASS': 'rest_framework.pagination.LimitOffsetPagination',
}

```

API:

```

GET <>/?limit=<limit>&offset=<offset>

```

## Step 10: Search by field in

import this to your `viewsets.py`

```python

from rest_framework import filters

```

add this to your viewsets class

```python

filter_backends = (filters.SearchFilter, )
search_fields = ('<field>','<field>',)

```

# One-to-Many Relationship [^7]

```python
from django.db import models

class User(models.Model):
    name = models.TextField()

    def __str__(self):
        return "{} - {}".format(str(self.id), self.name)


class Task(models.Model):
    name = models.TextField()
    assign = models.ForeignKey(User, on_delete=models.CASCADE)
```

# Starting with Mysql

Add this database settings to `your_project_name/settings.py`

```python

DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.mysql',
        'NAME': '[DB_NAME]',
        'USER': '[DB_USER]',
        'PASSWORD': '[PASSWORD]',
        'HOST': '[HOST]',   # Or an IP Address that your DB is hosted on
        'PORT': '3306',
    }
}

```

Install this module to your virtual environment

```

conda install mysql-python #if you are using virtual environment

pip install mysql-python #if you using are root environment

```


## Custom View [^8]

```python
from rest_framework import mixins


class CreateModelMixin(object):
    """
    Create a model instance.
    """
    def create(self, request, *args, **kwargs):
        event = request.data
        try:
            event['time'] = int(time.time())
        except Exception, e:
            print 'Set Time Error'
        serializer = self.get_serializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        self.perform_create(serializer)
        headers = self.get_success_headers(serializer.data)
        return Response(serializer.data, status=status.HTTP_201_CREATED, headers=headers)

    def perform_create(self, serializer):
        serializer.save()

    def get_success_headers(self, data):
        try:
            return {'Location': data[api_settings.URL_FIELD_NAME]}
        except (TypeError, KeyError):
            return {}

class YourViewSet(CreateModelMixin,
                  mixins.RetrieveModelMixin,
                  mixins.UpdateModelMixin,
                  mixins.DestroyModelMixin,
                  mixins.ListModelMixin,
                  GenericViewSet):
    queryset = YourModel.objects.all()
    serializer_class = YourModelSerializer
```

# Logging settings

Here is an example, put this settings dict into your `settings.py` file:

```python

LOGGING = {
    'version': 1,
    'disable_existing_loggers': False,
    'formatters': {
        'verbose': {
            'format': '%(levelname)s %(asctime)s %(module)s %(process)d %(thread)d %(message)s'
        },
        'simple': {
            'format': '%(levelname)s %(message)s'
        },
    },
    'filters': {
        'special': {
            '()': 'project.logging.SpecialFilter',
            'foo': 'bar',
        },
        'require_debug_true': {
            '()': 'django.utils.log.RequireDebugTrue',
        },
    },
    'handlers': {
        'console': {
            'level': 'INFO',
            'filters': ['require_debug_true'],
            'class': 'logging.StreamHandler',
            'formatter': 'simple'
        },
        'mail_admins': {
            'level': 'ERROR',
            'class': 'django.utils.log.AdminEmailHandler',
            'filters': ['special']
        }
    },
    'loggers': {
        'django': {
            'handlers': ['console'],
            'propagate': True,
        },
        'django.request': {
            'handlers': ['mail_admins'],
            'level': 'ERROR',
            'propagate': False,
        },
        'myproject.custom': {
            'handlers': ['console', 'mail_admins'],
            'level': 'INFO',
            'filters': ['special']
        }
    }
}

```
# Python: Build Python API Client package

## Step 1: Write document on [Swagger Editor](http://editor.swagger.io/#/)[^1]
## Step 2: Genenrate Client --> Python --> save `python-client.zip`
## Step 3: Extract `zip`
## Step 4: Open project in `Pycharm` rename `project directory`, `project name`, `swagger_client` package
## Step 5: [^2]
```
mkdir conda
cd conda
git clone https://github.com/hunguyen1702/condaBuildLocalTemplate.git
mv condaBuildLocalTemplate your_package_name
rm -rf .git README.md
```
## Step 6: Edit `meta.yaml` file in `your_package` folder

#### 6.1 Follow instruction inside `meta.yaml`

#### 6.2 Replace these line

```
requirements:
  build:
    - python
    - setuptools
  run:
    - python
```

##### with:

```
requirements:
  build:
    - python
    - setuptools
    - six
    - certifi
    - python-dateutil
  run:
    - python
    - six
    - certifi
    - python-dateutil
```

## Step 7:

```
cd ..
conda build your_package
```

## Step 8:
```
mkdir channel
cd channel
conda convert --platform all ~/anaconda/conda-bld/linux-64/your_package_0.1.0-py27_0.tar.bz2
```

## Step 9: Create `virtual-env`
```
name: your_env_name
dependencies:
- certifi=2016.2.28=py27_0
- openssl=1.0.2h=0
- pip=8.1.2=py27_0
- python=2.7.11=0
- python-dateutil=2.5.3=py27_0
- readline=6.2=2
- setuptools=20.7.0=py27_0
- six=1.10.0=py27_0
- tk=8.5.18=0
- wheel=0.29.0=py27_0
- zlib=1.2.8=0
- pip:
  - urllib3==1.15.1
```

## Step 10: Install:
```
conda install --use-local your_package
```

[^1]: [Swagger Syntax](http://swagger.io/specification/)
[^2]: [Github: Conda build template](https://github.com/hunguyen1702/condaBuildLocalTemplate/blob/master/build.sh)
See more:
1. [EMAIL_BACKEND & ADMIN setting](https://docs.djangoproject.com/en/1.9/ref/settings/#std:setting-EMAIL_BACKEND)
2. [Logging settings format in django](https://docs.djangoproject.com/en/1.9/topics/logging/#configuring-logging)

[^1]: [Django](https://www.djangoproject.com/)
[^2]: [Writing your first Django app, part 1](https://docs.djangoproject.com/en/1.9/intro/tutorial01/)
[^3]: [Django REST framework: Installation](http://www.django-rest-framework.org/#installation)
[^4]: [Django: Migrations](https://docs.djangoproject.com/en/1.9/topics/migrations/)
[^5]: [Building a Simple REST API for Mobile Applications](http://www.sitepoint.com/building-simple-rest-api-mobile-applications/)
[^6]: [Django: Models](https://docs.djangoproject.com/en/1.9/topics/db/models/)
[^7]: [How to show object details in Django Rest Framework browseable API?](http://stackoverflow.com/questions/33747597/how-to-show-object-details-in-django-rest-framework-browseable-api)
[^8]: [rest_framework:mixins](https://github.com/tomchristie/django-rest-framework/blob/master/rest_framework/mixins.py)