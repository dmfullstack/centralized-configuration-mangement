FROM 8-jdk-alpine3.8
VOLUME /tmp
ADD target/message-summary-1.0-SNAPSHOT.jar message-summary.jar
RUN sh -c 'touch /message-summary.jar'
ENV JAVA_OPTS="-Xms128m -Xmx256m"
EXPOSE 5555
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -jar /message-summary.jar" ]