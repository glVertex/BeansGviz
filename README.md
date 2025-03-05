# Beans Gviz
Builds a graph of Spring beans in Graphviz format.
![xdot_000](https://github.com/user-attachments/assets/7207c55a-4de8-4ddf-887a-e77e1fd93dab)

## Usage
### 1. Add the Spring actuator dependency to the Spring Boot project
build.gradle:
```
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-actuator'
}
```
### 2. Activate the actuator/beans endpoint
application.properties:
```
management.endpoints.web.exposure.include=beans
```
### 3. Launch a Spring Boot project
```
./gradlew bootRun
```

### 4. Build graph
```
# to generate *.gv files in the current directory
./BeansGviz http://localhost:8080/actuator/beans .

# to generate single.gv file
./BeansGviz http://localhost:8080/actuator/beans single.gv

# to open xdot for view graph (linux bash)
./BeansGviz http://localhost:8080/actuator/beans | xdot /dev/stdin
```

### 5. View graph
Use any graphviz viewer
```
xdot file.gv
# or
dot file.gv > file.svg
```
or copy content from file.gv to any Graphviz online viewer. (ex. https://dreampuf.github.io/GraphvizOnline)
