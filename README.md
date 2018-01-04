# AnDatabase

# `Just Focus On What To Do, Not In How To Do`


AnDatabase is a Database that provides simple way to manage data in simple desktop application Like Music Player, Video Player and Text Editor.
In AnDatabase data is organized into rows, columns and tables, and it is indexed to make it easier to find relevant information. Data gets updated, expanded and deleted as new information is added.


# _>>> Features_ : 
 1. No Sql Required, Sql Free Database
 2. Light Weight & Easy To Use
 3. Fast and Highly Secure 
 4. Configurable Database (Change Settings) As Your Project Need
 5. Data Stored In Highly Secured Encryption Algorithms With Encryption Key That Only Developer Knows.
 
# _>>> Basic Implementation_ :
 
 1. For Connecting To The AnDatabase
 `Connection.connect()`, It Simply Returns Boolean Value True If Database is Connected, Otherwise False.
 2. Creating Database  
 `Database mainDatabase = new Database("NameOfDatabase");` 
 3. Creating Table Inside mainDatabase  
 `Table loginFormTable = new Table();`  
 `loginFormTable.createTable("TableName",mainDatabase);`
 
 4. Add Columns Inside Table  
 `String[] colName = new String[]{"id", "name","email","password"};`  
 `loginFormTable.setColumns(colName);`
 
 5. Ok, That's It You Are Good To Go With AnDatabase And For Adding Data To Table Or Column, Use  
 `String[] rowData = new String[]{"1","UserName","UserEmail@Example.com"};`  
 `studentTB.addRow(rowData);`   
 
 # >>> Security Example : 

For Password Security AnDatabase Provide A Security Class That Encrypt Your Password With A Special Key Inside Program Then Add Into Column.  
Eg.  
     `Security.encrypt(Data,Key);`
     `Security.decrypt(EncryptedData,key);`

_**Basic Encryption Example**_ : 
 
```System.out.println(Security.encrypt("AnDatabase",123456789));```

_Output :_  
```ɢʏɥʂʕʂʃʂʔʆ```

_**Basic Decryption Example**_ : 
 
```System.out.println(Security.decrypt("ɢʏɥʂʕʂʃʂʔʆ",123456789));```

_Output :_  
```AnDatabase```    


 
![Alt tag](https://github.com/Anikesh1999/AnDatabase/blob/master/images/AnonDatabase.png)
