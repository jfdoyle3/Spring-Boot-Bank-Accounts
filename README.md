# SpringBoot Bank  - Microservice app
## Accout Service

Bank app that uses hibernate inheritence.
Database:  MySQL

project plan out spreadsheet:
https://docs.google.com/spreadsheets/d/1CHANcQdrlTSybI0oWXQ_a7vlf00wGf9mp6EWyuEZ-HA/edit?usp=sharing


Trello Board: https://trello.com/b/hkrepFSr

Miro: 

DrawIO: https://github.com/jfdoyle3/springboot-bank/blob/main/Untitled%20Diagram.drawio

Generate Account Numbers
int accountNumberChecking= Math.abs((1 + randNumber.nextInt(2)) * (int)Math.pow(10,9) + randNumber.nextInt((int)Math.pow(10,9)));
int accountNumberSavings = Math.abs(accountNumberChecking+((1 + randNumber.nextInt(2)) * (int)Math.pow(10,5) + randNumber.nextInt((int)Math.pow(10,5))));