@echo 
cd redis
redis-server.exe --service-uninstall --service-name sentinel26333
redis-server.exe --service-uninstall --service-name sentinel26334
redis-server.exe --service-uninstall --service-name sentinel26379

@pause



