## Команды Docker    
***   
### 1.  Запуск (storage) 
> cd C:\Users\Валентин\Desktop\2_Modul\storage    
> docker build -t storage-0.0.1 .  
> docker images 
> docker run -d -p 8081:8081 --network=host -t target/storage-0.0.1:latest    

### 2.  Запуск (postgreSQL в Docker)  
  2.1. запустить образ
> docker run --name postgres-cr-name -e POSTGRES_PASSWORD=postgres -d postgres    

  2.2. запустить CLI    
> psql --username=postgres-cr-name --dbname=shopbook    
> psql -U postgres -d postgres     // сокращенный вариант
> Выставляем порт базы наружу  
> docker run --name postgres-cr-name-14.1 -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=shopbook -d postgres:14.1