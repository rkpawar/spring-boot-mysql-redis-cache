
$ brew services stop mysql
$ pkill mysqld
$ rm -rf /usr/local/var/mysql/ # NOTE: this will delete your existing database!!!
$ brew postinstall mysql
$ brew services restart mysql
$ mysql -uroot

mysql> ALTER USER 'root'@'localhost' IDENTIFIED BY 'rose';
Query OK, 0 rows affected (0.04 sec)

mysql> exit
Bye
Then you are back to normal for dev.

$ sudo mysql -u root -p
Enter password:rose

# spring-boot-mysql-redis-cache
A temporary password is generated for root@localhost: eyYPbuX4pG<-

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
ranjanpawar@Ranjans-MacBook-Pro ~ % /usr/local/Cellar/redis/6.2.6/bin/redis-cli
127.0.0.1:6379>

127.0.0.1:6379> KEYS *
1) "cities::3"
   127.0.0.1:6379> Monitor
   OK
   1611720530.745829 [0 127.0.0.1:50787] "GET" "cities::3"

127.0.0.1:6379> flushall
OK


# Redis database property for cache
spring.redis.host=localhost
spring.redis.port=6379
#10 MINUTES
spring.cache.redis.time-to-live=600000
