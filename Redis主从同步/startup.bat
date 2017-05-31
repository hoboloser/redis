@echo
cd redis
redis-server.exe --service-start --service-name redis6377
redis-server.exe --service-start --service-name redis6376
redis-server.exe --service-start --service-name redis6375

@pause