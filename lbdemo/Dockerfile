# Use a minimal base image
FROM ubuntu:22.04

# Set the Tomcat version
ENV TOMCAT_VERSION=10.1.34

# Install dependencies
RUN apt-get update && \
    apt-get install -y wget && \
    apt-get clean

RUN wget -O /tmp/jdk_21.tar.gz https://download.oracle.com/java/21/latest/jdk-21_linux-x64_bin.tar.gz && \
	tar xf /tmp/jdk_21.tar.gz -C /opt/ && \
	rm /tmp/jdk_21.tar.gz
	#mv /opt/apache-tomcat-${TOMCAT_VERSION} /opt/jdk-21

# Download and extract Tomcat
RUN wget -O /tmp/tomcat.tar.gz https://dlcdn.apache.org/tomcat/tomcat-10/v10.1.34/bin/apache-tomcat-10.1.34.tar.gz && \
    tar xf /tmp/tomcat.tar.gz -C /opt && \
    rm /tmp/tomcat.tar.gz && \
    mv /opt/apache-tomcat-${TOMCAT_VERSION} /opt/tomcat && \
	whereis java && \
	mv /opt/jdk-21.0.5 /opt/jdk-21 && \
	whereis java

# Set environment variables
ENV CATALINA_HOME=/opt/tomcat
ENV PATH=$CATALINA_HOME/bin:$PATH
ENV JAVA_HOME=/opt/jdk-21
ENV PATH=$JAVA_HOME/bin:$PATH

# Expose Tomcat port
EXPOSE 8080

# Clean up unnecessary files
RUN apt-get purge -y openjdk-21-jdk wget && \
    apt-get autoremove -y && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/* /opt/tomcat/webapps/*
	
	
COPY target/lbdemo-0.0.2-SNAPSHOT.war /opt/tomcat/webapps/demo.war

# Start Tomcat
CMD ["catalina.sh", "run"]