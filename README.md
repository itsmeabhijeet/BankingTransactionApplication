# BankingTransactionApplication
A Sandbox Java banking application that can be used for: ● Sending money between two predefined accounts with a positive starting balance ● Requesting account balance and list of transactions
-------------------------------------------------------------------------------------------------------------------------------------
Application Details below :

The application is developed using Spring Boot and exposes two Api for the below two purpose :
  1.Sending money between two predefined accounts with a positive starting balance :
      Request :
      HTTP POST API: /transaction
      Body :    {
                    "fromAccountNumber": 1,
                    "toAccountNumber": 2,
                    "amount":1000
                }
      Response: 
        Success > Code : 200, message: Transaction Success
        Error > Code: 400, message: Transaction Failed
        
                
  2.Requesting account balance and list of transactions : 
  Request:
   HTTP GET API : /transactionDetails?accountNumber=1
   Response : 
          [
            {
              "transactionID": 1,
              "accountID": 1,
              "transactionTypeId": 2,
              "currentDate": "2019-02-24",
              "amount": 2000
            },
            {
                "transactionID": 2,
                "accountID": 1,
                "transactionTypeId": 2,
                "currentDate": "2019-02-26",
                "amount": 1000
            }
         ]
         
  
  --------------------------------------------------------------------------------------------------------------------
  Ways to execute the project.
  
  1. Executing the project manually.
   > Download and extract the project.
   > Import it as a gradle project in your development tool like eclipse or IntelliJ.
   > Install spring boot plugin in the working tool like in eclipse one can download from eclipse market place.
   > execute the project as spring boot project.
   > open PostMan as the tool to test REST API.
   
   2. Executing the project using gradle.
    > Download and extract the project.
    > Install gradle 4.2 higher version in your system.
    > Build the project using gralde and use the jar to run the project.
    > use this command to run the project $ java -jar target/myapplication.jar
    > Now use postman to test the application.
    
