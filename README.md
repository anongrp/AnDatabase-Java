# AnDatabase

# `Just Focus On What To Do, Not In How To Do`


AnDatabase is a Database that's provide simple way to manage data in simple desktop application Like Music Player,Video Player and Text Editor.
In AnDatabase data is organized into rows, columns and tables, and it is indexed to make it easier to find relevant information. Data gets updated, expanded and deleted as new information is added.


# _>>> Features_ : 
 1. No Sql Required Sql Free Databaes
 2. Fast and Highly Secure 
 3. Data Stored In Highly Secured Encryption Algorithms With Encryption Key That's Only Developer Know.
 
# _>>> Basic Implementation_ :
 
 1. For Connecting To The AnDatabase
 `Connection.connect()`, Its Simple Return Boolean Value If Database is Connected Than True Otherwise Return False.
 2. Creating Database  
 `Database mainDatabase = new Database("NameOfDatabase");` 
 3. Creating Table Inside mainDatabase  
 `Table loginFormTable = new Table();`  
 `loginFormTable.createTable("TableName",mainDatabase);`
 
 4. Add Columns Inside Table  
 `String[] colName = new String[]{"id", "name","email","password"};`  
 `loginFormTable.setColumns(colName);`
 
 5. Ok That's It Your Good To Go With AnDatabase And For Adding Data To Table Or Column Use  
 `String[] rowData = new String[]{"1","UserName","UserEmail@Example.com"};`  
 `studentTB.addRow(rowData);`   
 
 # >>> Security Example : 

For Password Security AnDatabase Provide A Security Class Thats Encrypt Your Password With A Special Key Inside Program Than Add Into Column.  
Eg.  
     `Security.encrypt(Data,Key);`
     `Security.decrypt(EncryptedData,key);`

_**Basic Encryption Example**_ : 
 
![Encryption](https://raw.githubusercontent.com/anongrp/AnDatabase/master/images/Untitled-2.png)

_Output :_  
```ɢʏɥʂʕʂʃʂʔʆ```

_**Basic Decryption Example**_ : 
 
![Decryption](https://raw.githubusercontent.com/anongrp/AnDatabase/master/images/Untitled-1.png)

_Output :_  
```AnDatabase```    


 
![Anon Database](https://github.com/Anikesh1999/AnDatabase/blob/master/images/AnonDatabase.png)
