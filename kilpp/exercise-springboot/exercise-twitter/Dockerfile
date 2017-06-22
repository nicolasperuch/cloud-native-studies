FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD build/libs/exercise-twitter.jar twitterapp.jar
EXPOSE 8003
RUN sh -c 'touch /twitterapp.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /twitterapp.jar" ]