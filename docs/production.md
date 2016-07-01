# Production with `docker`

Base Image: [magizbox/conda2.7/](https://hub.docker.com/r/magizbox/conda2.7/)

Docker Folder

```
your_app/
├── app
│   ├── config
│   └── main.py
├── Dockerfile
└── run.sh
```

`Dockerfile`

```
FROM magizbox/conda2.7:4.0

ADD ./app /app
ADD ./run.sh /run.sh

RUN conda env create -f environment.yml
```

`run.sh`

```
source activate your_environment

cd /app

python main.py
```

Compose

```
 service:
  build: ./service-app
  command: 'bash run.sh'
```

Note: an other python conda with lower version (such as 3.5), will occur error when install requests package