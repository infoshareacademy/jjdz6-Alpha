FROM jboss/wildfly

MAINTAINER "infoShare Academy"

RUN wildfly/bin/add-user.sh admin admin --silent

EXPOSE 8080

ADD target/child-development-support-system-0.2-SNAPSHOT.war wildfly/standalone/deployments/

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]


