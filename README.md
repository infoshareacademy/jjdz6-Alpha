# jjdz6-Alpha

## How to initialize:

        1. install maven in your system ( ubuntu : sudo apt install mvn )
        2. build project go to project dir where is pom.xml file, then : mvn install
        3. execute jar from target/ dir: java -jar childDevelopmentSupportSystem-0.2.jar

## How to use di
        1. initialize DI: 
        2. print initialized services
        3. use service from di
        
## Maven targets (experimental)

        1. mvn clean package dependency:copy-dependencies
        2. mvn clean package (build war package with jar dependencies)
        3. mvn dependency:resolve (download external packages to .m2 )
        4. mvn install dependency:copy-dependencies -DincludeScope=runtime -DoutputDirectory=target/lib (build jar file with dependencies as one package)
        5. mvn clean compile assembly:single (build jar file with dependencies as one package)
        
  <!-- mvn install dependency:copy-dependencies -DincludeScope=runtime -DoutputDirectory=target/lib -->
  <!-- mvn clean compile assembly:single -->

## App docker , how to up
        1. docker-compose up -d or docker-compose up (in main app dir)

## App docker , how to stop
        1. docker-compose stop or Ctrl + Z (in main app dir )

## App docker, how to reload
        1. docker-compose stop
        2. remove containers 
        3. Clear db docker schema : rm -rf db/data/* 

## How to deploy app to docker wildfly

        1. mvn clean package wildfly:deploy

## How to redeploy app to docker wildly

        1. mvn wildfly:redeploy

## How to uneploy app to docker wildly

        1. mvn wildfly:undeploy
## How to set file encoding in docker/wildfly JAVA_OPTS (docker-compose.yml)
      app:
        container_name: "wwr-app"
        environment:
          - JAVA_OPTS=-server -Xms512m -Xmx2048m -XX:MetaspaceSize=96M -XX:MaxMetaspaceSize=256m -XX:+UseAdaptiveSizePolicy -XX:MaxMetaspaceSize=1024m -Djava.net.preferIPv4Stack=true -Djboss.modules.system.pkgs=org.jboss.byteman -Djava.awt.headless=true-Djava.net.preferIPv4Stack=true -Dfile.encoding=UTF-8
        build:
          context: .
        ports:
          - 8080:8080
          - 9990:9990
        depends_on:
          - db
        links:
          - db
        dns: 8.8.8.8
## How to start containers separately via docker-compose
    docker-compose start [sevice-name]
    docker-compose start db
    docker-compose start app
