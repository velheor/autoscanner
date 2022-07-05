FROM openjdk:11
ENV TZ=Europe/Minsk
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
#COPY config/ /config/
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} target/autoscanner.jar
WORKDIR "/target"
ENTRYPOINT ["java","-jar","autoscanner.jar"]

EXPOSE 8087