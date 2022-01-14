FROM alpine:edge
MAINTAINER Tadeo Rivera <xtecuan@protonmail.com>
RUN sed -i 's/https/http/' /etc/apk/repositories
RUN apk --no-cache add --update openjdk11
RUN apk --no-cache add --update util-linux pciutils usbutils coreutils binutils findutils grep
RUN apk --no-cache add --update bash bash-doc tzdata nano  && rm -rf /var/cache/apk/*
RUN cp /usr/share/zoneinfo/America/El_Salvador  /etc/localtime
RUN echo "America/El_Salvador" > /etc/timezone
RUN date
RUN mkdir -p /opt/app
RUN mkdir -p /deployments/exceltemplates
EXPOSE 8080
EXPOSE 8443
COPY ./scripts/run-app.sh /opt/app
COPY  ./exceltemplates/*.xlsx /deployments/exceltemplates/
COPY ./target/sgipd-web-bootable.jar /opt/app
COPY ./bashrc /root/.bashrc
RUN chmod a+x /root/.bashrc
RUN chmod a+x /opt/app/sgipd-web-bootable.jar
RUN chmod a+x /opt/app/run-app.sh
RUN chmod 777 /deployments/exceltemplates/*.xlsx
WORKDIR /opt/app
CMD /opt/app/run-app.sh


