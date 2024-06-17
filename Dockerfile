# Can you explain what is this file for? What does it do?
FROM 3-openjdk-8-slim
COPY pom.xml /tmp/pom.xml
RUN mvn -B -f /tmp/pom.xml -s /usr/share/maven/ref/settings-docker.xml dependency:resolve
