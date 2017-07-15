FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD build/libs/exercise-github.jar githubapp.jar
EXPOSE 8002
RUN sh -c 'touch /githubapp.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /githubapp.jar" ]