# Handling MySQL and MongoDB databases with Java
Basic data handling with Java, MySQL and MongoDB

Libraries needed:
* [MySQL Connector 8.0.21](https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.21)
* [MongoDB Java Driver 3.4.2](https://mvnrepository.com/artifact/org.mongodb/mongo-java-driver/3.4.2)
* [MongoDB Java Driver Core 3.4.2](https://mvnrepository.com/artifact/org.mongodb/mongodb-driver-core/3.4.2)
## MySQL
Given a database, this program is able to create a table ```pet``` if ```pet``` doesn't already exist.

```mysql> describe pet;```

Field | Type | Null | Key | Default | Extra
------|------|------|-----|---------|------
name | varchar(20) | YES  |     | NULL    |
owner   | varchar(20) | YES  |     | NULL    |
species | varchar(20) | YES  |     | NULL    |
sex     | char(1)     | YES  |     | NULL    |

Other features of the program:
* Show all rows in the table.
* Insert new row.
* Delete a row given parameters (key, value).
    * ```DELETE FROM pet WHERE key=value```

## MongoDB
Compared to MySQL, MongoDB is more flexible regarding handling data.

Given a database ```test```, the program is able to:
* See all collections inside ```test```.
* Read all documents inside one collection.
* Create a new collection.
* Insert documents into a collection.
* Remove a document from a collection.
* Drop an entire collection.