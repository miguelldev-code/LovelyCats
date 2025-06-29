# Imagen base de Tomcat
FROM tomcat:9.0-jdk17

# Elimina aplicaciones por defecto
RUN rm -rf /usr/local/tomcat/webapps/*

# Copia tu WAR
COPY target/LovelyCats-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Exponer el puerto (Tomcat default 8080)
EXPOSE 8080

# Comando de arranque
CMD ["catalina.sh", "run"]
