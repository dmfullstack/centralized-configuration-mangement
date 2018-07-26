# message summary


This is a simple java microservice to search messages sent out by
[go-kafka-alert](https://github.com/malike/go-kafka-alert) and also 
to provide summary of messages sent out by channel that is `EMAIL`, `SMS` 
and `API`.

The intent of this is to show how we can have distributed/cloud native applications written in `Go` 
and `Java` work with a config server to share properties as well to demonstrate dynamic 
reloading of configuration without microservice down time.


#### API

1. Search messages to search messages in the database. 

`curl -H "Content-Type:application/json" -XPOST "http://localhost:5555/message/search"  -d {"param":"malike"}'`



Sample Response :

```json

{
  "status": true,
  "result": [
    {
      "_id": {
        "timestamp": 1526746727,
        "machineIdentifier": 13431295,
        "processIdentifier": 6525,
        "counter": 15171200,
        "date": 1526746727000,
        "time": 1526746727000,
        "timeSecond": 1526746727
      },
      "messageId": "84509442st.malike@gmail.com12345",
      "reference": "12345EMAIL",
      "alertId": "12345_EMAIL_st.malike@gmail.com",
      "unmappeddata": {
        
      },
      "subject": "Signup For Service",
      "content": "<html><head></head><body> Hello <no value>, Thanks for subscribing to <no value> </body></html>",
      "recipient": "st.malike@gmail.com",
      "dateCreated": 1526746727084,
      "messageResponse": {
        "response": "SENT",
        "status": "SUCCESS",
        "timeOfResponse": 1526746730213
      }
    }
  ],
  "message": "SUCCESS",
  "count": 12
}


```

2. Get message summary with sample request to get message summary by channel `EMAIL`.  


`curl -H "Content-Type:application/json" -XPOST 
"http://localhost:5555/message/summary"  -d '{"startDate":"2018-07-02","endDate":"2019-07-02","channel":"email"}'`

Response : 

```json


{
  "status": true,
  "result": [
    {
      "_id": "535 5.7.8 Username and Password not accepted. Learn more at 5.7.8 https://support.google.com/mail/?p=BadCredentials o13-v6sm239112wmc.33 - gsmtp",
      "value": {
        "count": 1
      }
    },
    {
      "_id": "FAILED",
      "value": {
        "count": 3
      }
    },
    {
      "_id": "SENT",
      "value": {
        "count": 12
      }
    }
  ],
  "message": "SUCCESS",
  "count": 0
}


```

[Read more](https://malike.github.io/Configuration-Management-For-Microservices-And-Distributed-Systems/)
