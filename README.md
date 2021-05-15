# CoWin API Integrations
Pre-requisite:
- Java - jdk1.8+
- Maven - apache maven 3.X.X

Deployment steps:
- Git Clone project
- Maven Build Jar: mvn clean install
- Run JAR: java -jar target/apis-0.0.1-SNAPSHOT.jar

API Documentation: http://localhost:8080/cowin/service/swagger-ui/#/

## Update
Added Twitter Bot changes which posts status based on pincode, district and state. There is one option to update available slot for whole country as well. 
Please check rate limiter as per your twitter developer account.
URL: https://developer.twitter.com/en/docs/twitter-api
