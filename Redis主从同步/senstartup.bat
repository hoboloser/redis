@echo 
cd redis
redis-server.exe  sentinel26333.conf --sentinel  
redis-server.exe  sentinel26334.conf --sentinel  
redis-server.exe  sentinel26379.conf --sentinel  

@pause


