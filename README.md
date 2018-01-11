# AnDatabase : _The Anon Group Service_

# `Just Focus On What To Do, Not In How To Do`


AnDatabase is a Database that provides a simple way to manage data in simple desktop application Like Music Player, Video Player, and Text Editor. In AnDatabase data is organized into rows, columns, and tables, and it is indexed to make it easier to find relevant information. Data gets updated, expanded and deleted as new information is added.


# _>>> Features_ : 
 1. No SQL Required, SQL Free Database
 2. Fast and Highly Secure 
 3. Table Exportation Support (To CSV File)
 4. Data Stored In Highly Secured Encryption Algorithms With Encryption Key That's Only Developer Knows.
 
# _>>> Download_ :    

![AnDatabase v2.1jar](https://github.com/anongrp/AnDatabase/raw/master/AN%20Database%20v2.1.jar)    
![AnDatabase v2.0.jar](https://github.com/anongrp/AnDatabase/raw/master/AN%20Database.jar)

# _>>> Projects Using AnDatabase_ :   

* <a href="https://github.com/anongrp/ThunderGet">ThunderGet</a>
* <a href="https://github.com/Anikeshpatel/Lucid-Smart-Buddy">Lucid-Smart-Buddy</a>
 
# _>>> Basic Implementation_ :
 
 1. For Connecting To The AnDatabase `Connection.connect();` It Simply Returns Boolean Value True If Database is Connected Otherwise False.     
 
 2. Creating Database  
 ```java 
 Database mainDatabase = new Database("NameOfDatabase");
 ```  
 3. Creating Table Inside mainDatabase  
 ```java 
 Table loginFormTable = new Table();  
 loginFormTable.createTable("TableName",mainDatabase);
 ```
 
 4. Add Columns Inside Table  
 ```java 
 String[] colName = new String[]{"id", "name","email","password"};  
 loginFormTable.setColumns(colName);
 ```
 
 5. Ok That's It You Have Good To Go With AnDatabase And For Adding Data To Table Or Column Use  
 ```java 
 String[] rowData = new String[]{"1","UserName","UserEmail@Example.com"};
 studentTB.addRow(rowData);
 ```
 
 # >>> Security Example : 

For Password Security AnDatabase Provide A Security Class That Encrypt Your Password With A Special Key Inside Program Then Add Into Column.  
Eg.  
```java 
Security.encrypt(Data,Key);
Security.decrypt(EncryptedData,key);
```

_**Basic Encryption Example**_ : 
 
![Encryption](https://raw.githubusercontent.com/anongrp/AnDatabase/master/images/Untitled-2.png)

_Output :_  
```ɢʏɥʂʕʂʃʂʔʆ```

_**Basic Decryption Example**_ : 
 
![Decryption](https://raw.githubusercontent.com/anongrp/AnDatabase/master/images/Untitled-1.png)

_Output :_  
```AnDatabase```    


# >>> Standart Way To Implement AnDatabase   
![Standard Way](https://raw.githubusercontent.com/anongrp/AnDatabase/master/images/standart.png)     

 
![Anon Database](https://github.com/Anikeshpatel/AnDatabase/blob/master/images/AnonDatabase.png)  
