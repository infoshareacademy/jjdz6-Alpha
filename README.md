# jjdz6-Alpha
# dm

## How to initialize:

        1. install maven in your system ( ubuntu : sudo apt install mvn )
        2. build project go to project dir where is pom.xml file, then : mvn install
        3. execute jar from target/ dir: java -jar childDevelopmentSupportSystem-0.1.jar

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



### Pytania do trenara j2ee