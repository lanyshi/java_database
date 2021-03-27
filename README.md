# java_database
Basic data handling with Java, mysql.MySQL and MongoDB

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
