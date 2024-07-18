# Java-products-CRUD-app

Инструкция по запуску приложения:

1. Убедитесь, что у вас установлен JDK 17.
   
2. Клонируйте репозиторий c ветки develop на локальную машину.
```
cd <путь до вашего проекта>
git clone https://github.com/BanderlogCumberbatch/Java-products-CRUD-app.git -b develop
```
4. Убедитесь, что у вас установлен и запущен PostgreSQL. Создайте базу данных. Вставьте в неё таблицу:
``` sql
CREATE TABLE products (
    product_id uuid DEFAULT gen_random_uuid(),
    article_number VARCHAR(100) UNIQUE,
    name VARCHAR(100),
    description VARCHAR(100),
    category VARCHAR(100),
    price double precision,
    quantity INTEGER,
    last_modified timestamp,
    created_at timestamp,
    PRIMARY KEY (product_id)
);
```
4. В файле src/main/resources/application.properties укажите настройки подключения к базе данных.
```
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```
5. В своей IDE c предустановленным Maven выполните команду для сборки проекта и генерации .jar файла.
```
mvn clean package
```
6. Запустите приложение с помощью следующей команды.
```
java -jar target/app-1.0.0-SNAPSHOT.jar
```
Теперь приложение должно быть запущено и доступно по адресу http://localhost:8080/products.
