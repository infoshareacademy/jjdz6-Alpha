# jjdz6-Alpha

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

## How to build and run Docker with wildfly

    1. [sudo] docker build .
    2. 


### Pytania do trenara j2ee
 * jak przygotowac build ktory bedzie sie skladal z budowanej paczki jar ktora bedzie uzywana w war ? 
 * czy biblioteki w depencencies przekopiowuja sie same do lib w paczce war ?
 * jak przekazywać konfigurację z pliku web.xml do serwleta (przyklad) i co to jest configuracja kontekstowa?
 * gdzie powinno sie przechowywac konfiguracje serwleta ( w projektach komercyjnych ) 
 
 