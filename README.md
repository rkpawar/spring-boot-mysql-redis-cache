# spring-boot-mysql-redis-cache
1) mysql> CREATE DATABASE testdb;
   We create a new testdb database.
2) This is SQL to create the cities table.
mysql> use testdb;
mysql> source cities_mysql.sql

3) maven build and run the application
   
4) test the API : http://localhost:8080/cities and http://localhost:8080/cities/1

5)To have launchd start redis now and restart at login:
>brew services start redis
to stop it, just run:
>brew services stop redis


6)Open Redis-cli
ranjanpawar@Ranjans-MacBook-Pro ~ % /usr/local/Cellar/redis/6.0.10/bin/redis-cli
127.0.0.1:6379>

127.0.0.1:6379> KEYS *
1) "cities::3"
   127.0.0.1:6379> Monitor
   OK
   1611720530.745829 [0 127.0.0.1:50787] "GET" "cities::3"

127.0.0.1:6379> flushall
OK
 

