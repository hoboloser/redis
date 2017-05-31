@echo
cd redis
redis-server.exe --service-start --service-name sentinel26333
redis-server.exe --service-start --service-name sentinel26334
redis-server.exe --service-start --service-name sentinel26379

@pause