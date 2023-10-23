FROM tomcat:latest
COPY target/cvillegas.war /usr/local/tomcat/webapps/
COPY server.xml /usr/local/tomcat/conf/
EXPOSE 9191
CMD ["catalina.sh", "run"]