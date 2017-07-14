FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD build/libs/exercise-twittergithub.jar twittergithubapp.jar
EXPOSE 8001
RUN sh -c 'touch /twittergithubapp.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /twittergithubapp.jar" ]