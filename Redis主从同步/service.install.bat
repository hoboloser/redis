@echo 
cd redis
redis-server.exe --service-install F:/Redis/Redis主从同步/redisconfig/redis.6377.conf --service-name redis6377
redis-server.exe --service-install F:/Redis/Redis主从同步/redisconfig/redis.6376.conf --service-name redis6376
redis-server.exe --service-install F:/Redis/Redis主从同步/redisconfig/redis.6375.conf --service-name redis6375
@pause

