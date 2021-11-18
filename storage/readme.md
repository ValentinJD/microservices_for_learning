Команды Docker
cd C:\Users\Валентин\Desktop\2_Modul\storage
docker build -t storage-0.0.1 .
docker images
docker run -d -p 8080:8080 -t target/storage-0.0.1:latest