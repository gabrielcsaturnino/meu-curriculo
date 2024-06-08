FROM maven:latest AS build
WORKDIR /app
COPY . /app
RUN mvn clean package

FROM tomcat:latest



# Copie o arquivo WAR construído para o diretório webapps do Tomcat
COPY target/ROOT.war /usr/local/tomcat/webapps/

# Exponha a porta do Tomcat
EXPOSE 8080
