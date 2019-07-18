FROM jboss/wildfly:latest
ADD ./target/child-development-support-system-0.2-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/
MAINTAINER "infoShare Academy"
USER jboss
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]


# FROM jboss/wildfly
# ADD target/ApkaWebowa.war /opt/jboss/wildfly/standalone/deployments/
# RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent
# CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]