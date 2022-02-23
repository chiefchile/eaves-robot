# Eaves Robot

[https://joneaves.wordpress.com/2014/07/21/toy-robot-coding-test/](https://joneaves.wordpress.com/2014/07/21/toy-robot-coding-test/)

### Building the app
Prerequisites: JDK 8, Maven
1. Execute the following commands on your shell
```
mkdir eaves-robot
cd eaves-robot
git clone https://github.com/chiefchile/eaves-robot .
mvn install
```

### Running the app
1. Build the app (see above)
2. Execute the following commands in the project's root directory
```
cd target
java -jar eaves-robot-1.0.0-fat.jar
```