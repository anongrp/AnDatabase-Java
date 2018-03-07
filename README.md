# AnonGrp : _The Mind In Your Hand_

# `Just Focus On What To Do, Not In How To Do`


## <p>Under Development ...</p>

AnDatabase is a Database that provides a simple way to manage data in simple desktop application Like Music Player, Video Player, and Text Editor. In AnDatabase data is organized into rows, columns, and tables, and it is indexed to make it easier to find relevant information. Data gets updated, expanded and deleted as new information is added.


## _> Features_ : 
 1. No SQL Required, SQL Free Database
 2. Easy Implementation
 3. Fast, Flexible and Secure 
 4. Table Exportation Support (To CSV for Excel, JSON File for Web Data Sharing & in XML)
 5. Data Stored In Highly Secured Encryption Algorithms With Encryption Key That's Only Developer Knows.
 6. Easy Implementation Only Maximum 10 Lines Of Code Required For Implementing AnDatabase.  
 
##  ![Beta Release](https://github.com/anongrp/AnDatabase/releases)    
![AnDatabase v2.5 JRE 9.jar (Latest Stable Version) ](https://github.com/anongrp/AnDatabase/raw/master/Release/AN%20Database%20v2.5%20JRE%209.jar)  
     

 ### _Looking For Python_ Visit ![AnPyDatabase](https://github.com/Anikeshpatel/AnPyDatabase)    
## _> Projects Using AnDatabase_ :   

* <a href="https://github.com/anongrp/ThunderGet">ThunderGet</a>
* <a href="https://github.com/Anikeshpatel/Lucid-Smart-Buddy">Lucid-Smart-Buddy</a>
* <a href="https://github.com/anikeshpatel/colorcode-pro">ColorCode Pro</a>   
* <a href="https://github.com/anongrp/Portume">Portume</a>   
 
# _> Basic Implementation_ :

### _List Of Classes_ :    
| Classes       | Summary            |
| ------------- |:------------------:|
| Database      | Handle Database    |
| Table         | Handle Tables      |
| Security      | Provide Encryption |

 1. For Connecting To The AnDatabase `Connection.connect();` It Simply Returns Boolean Value True If Database is Connected Otherwise False.     
 
 2. Creating Database  
 ```java 
 Database mainDatabase = new Database("NameOfDatabase");
 ```  
 3. Creating Table Inside mainDatabase  
 ```java 
 String[] colName = new String[]{"name","email","password"};
 Table loginFormTable = new Table("TableName",mainDatabase,colName);  
 ```
 
 4. Ok That's It You Have Good To Go With AnDatabase And For Adding Data To Table Or Column Use  
 ```java 
 String[] rowData = new String[]{"UserName","UserEmail@Example.com","12345"};
 studentTB.insertRow(rowData);
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


# >>> Standard Way To Implement AnDatabase   
![Standard Way](https://raw.githubusercontent.com/anongrp/AnDatabase/master/images/standart.png ) 

 
![Anon Database](https://github.com/Anikeshpatel/AnDatabase/blob/master/images/AnonDatabase.png)  
