FROM jboss/wildfly:latest

MAINTAINER "infoShare Academy"

USER jboss

RUN wildfly/bin/add-user.sh admin admin --silent

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]