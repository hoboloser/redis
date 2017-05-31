@echo 
cd redis

redis-server.exe --service-install F:/Redis/Redis-jiqun/redisconfig/redis.7001.conf --service-name redis7001
redis-server.exe --service-install F:/Redis/Redis-jiqun/redisconfig/redis.7002.conf --service-name redis7002
redis-server.exe --service-install F:/Redis/Redis-jiqun/redisconfig/redis.7003.conf --service-name redis7003
redis-server.exe --service-install F:/Redis/Redis-jiqun/redisconfig/redis.7004.conf --service-name redis7004
redis-server.exe --service-install F:/Redis/Redis-jiqun/redisconfig/redis.7005.conf --service-name redis7005
redis-server.exe --service-install F:/Redis/Redis-jiqun/redisconfig/redis.7006.conf --service-name redis7006
@pause

