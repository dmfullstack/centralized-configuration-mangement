FROM 8-jdk-alpine3.8
VOLUME /tmp
ADD target/config-server-1.0-SNAPSHOT.jar config-server.jar
RUN sh -c 'touch /config-server.jar'
ENV JAVA_OPTS="-Xms128m -Xmx256m"
EXPOSE 8888
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -jar /config-server.jar" ]