FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD /build/libs/Twitter-0.0.1-SNAPSHOT.jar twitter.jar
RUN sh -c 'touch /twitter.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /twitter.jar" ]
