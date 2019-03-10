FROM openjdk:8-jre-alpine
LABEL maintainer="baba"


	
ENV VERTICLE_FILE ceibademo-0.0.1-SNAPSHOT.jar

ENV VERTICLE_HOME /usr/verticles

ENV JAVA_OPTS=""

EXPOSE 9017


# Copy your verticle to the container
COPY target/$VERTICLE_FILE $VERTICLE_HOME/

# Launch the verticle
WORKDIR $VERTICLE_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java  $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar  $VERTICLE_FILE"]