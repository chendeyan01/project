FROM centos
MAINTAINER chendeyan
COPY jdk1.8.0_172 jdk1.8.0
ADD ./jenkins/target/jenkins-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_HOME=/jdk1.8.0
ENV PATH=$JAVA_HOME/bin:$PATH
ENV CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/toos.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","/app.jar"]