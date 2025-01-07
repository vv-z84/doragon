FROM amazoncorretto:17.0.13-alpine3.20

RUN apk update && apk upgrade

COPY . /app

WORKDIR /app

CMD ["/bin/sh", "-c", "./gradlew run --args='--path /watchme'"]
