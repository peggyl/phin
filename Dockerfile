FROM openjdk:8-jre
EXPOSE 8080

COPY . /phin

WORKDIR /phin
RUN ./sbt compile

CMD ["./sbt", "run"]
