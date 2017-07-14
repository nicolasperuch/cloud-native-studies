FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD /build/libs/Manager-0.0.1-SNAPSHOT.jar manager.jar
RUN sh -c 'touch /manager.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /manager.jar" ]
