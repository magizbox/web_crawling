# Java: Production (Docker)

Production with `java`

Base Image: [java][/java](https://hub.docker.com/_/java/)

Docker Folder

```
your-app/
├── app
│   ├── bin
│   ├───── your_app.sh
│   └── lib
├── Dockerfile
└── run.sh
```

`Dockerfile`

```
FROM java:7

COPY run.sh run.sh
```

`run.sh`

```
cd /app/bin
chmod u+x your_app.sh
./your_app.sh
```

Compose

```
 service:
  build: ./your_app
  command: 'bash run.sh'
```
