#Covid 19 dashboard API
Covid 19 dashboard provides API stats of Novel Corona virus statistics in India. 

Thanks to the api provided by https://github.com/covid19india/api,
We consume below mentioned 2 apis,
1. India - https://api.covid19india.org/data.json
2. State Daily - https://api.covid19india.org/states_daily.json

This project is hosted on heroku at the below url : https://covid-19-dashboard-rest-api.herokuapp.com/

API's are authenticated and authorized using JWT tokens.

UI of this app is available on : https://covid-19-dashboard-ui.herokuapp.com/

## To start application in local

Run below command,
`mvn spring-boot:run -Dspring-boot.run.profiles=dev`
Note - This project uses postgres DB

## To start tests in local

Run below command,
`mvn test -Dspring-boot.run.profiles=dev`

## API reference

Thanks to https://github.com/covid19india/api for providing API,
1. India - https://api.covid19india.org/data.json
2. State Daily - https://api.covid19india.org/states_daily.json