FROM openjdk:8-jdk-alpine

ENV FILEBEAT_PATH /etc/filebeat

ENV FILEBEAT_VERSION=6.4.2
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN apk add --update-cache curl bash go libc6-compat supervisor && \
    rm -rf /var/cache/apk/* && \
    curl https://artifacts.elastic.co/downloads/beats/filebeat/filebeat-${FILEBEAT_VERSION}-linux-x86_64.tar.gz -o /filebeat.tar.gz && \
    tar xzvf filebeat.tar.gz && \
    rm filebeat.tar.gz && \
    mv filebeat-${FILEBEAT_VERSION}-linux-x86_64 filebeat && \
    cd filebeat && \
    cp filebeat /bin

COPY filebeat.yml /etc/filebeat/filebeat.yml
RUN mkdir -p /var/log/supervisor && mkdir -p /etc/supervisor/conf.d
ADD supervisor.conf /etc/supervisor.conf

EXPOSE 8080
RUN chmod go-w /etc/filebeat/filebeat.yml
CMD ["supervisord", "-c", "/etc/supervisor.conf"]