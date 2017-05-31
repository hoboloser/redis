@echo 
cd redis
redis-server.exe --service-install F:/Redis/Redis主从同步/sentinelconfig/sentinel26333.conf --service-name sentinel26333
redis-server.exe --service-install F:/Redis/Redis主从同步/sentinelconfig/sentinel26334.conf --service-name sentinel26334
redis-server.exe --service-install F:/Redis/Redis主从同步/sentinelconfig/sentinel26379.conf --service-name sentinel26379
@pause

