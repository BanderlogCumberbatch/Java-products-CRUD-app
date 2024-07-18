# Используем официальный образ OpenJDK в качестве базового образа
FROM openjdk:11-jre-slim

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем файл jar вашего приложения в контейнер
COPY target/app-1.0.0-SNAPSHOT.jar app.jar

# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]