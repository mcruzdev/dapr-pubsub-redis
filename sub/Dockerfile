FROM eclipse-temurin:17-jre
ENV PORT 8080
EXPOSE 8080

COPY ./build/libs/sub-0.1.0.jar /opt/app.jar
WORKDIR /opt
ENTRYPOINT exec java $JAVA_OPTS -noverify -jar app.jar