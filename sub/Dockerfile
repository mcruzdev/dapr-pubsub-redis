FROM eclipse-temurin:17-jre
ENV PORT 8080
EXPOSE 8080

COPY ./build/libs/script-0.0.1-SNAPSHOT.jar /opt/app.jar
WORKDIR /opt
ENTRYPOINT exec java $JAVA_OPTS -noverify -jar app.jar