# Консольное приложение Учёт студентов

## Описание проекта
Проект реализует учет студентов. Вы можете просмотреть, создать,
удалить разных студентов.

В файле application.yaml находятся настройки приложения. 
В строке app.creat-students: ${CREATE_ON_START:true} можно установить будет
ли приложение при запуске создавать студентов (true) или нет (false).
В настройках по умолчанию стоит true.   

В командной строке приложение принимает 4 запроса:
- get (возвращает список студентов)
- add имя_студента фамилия_студента возраст_студента (добавляет студента)
- delete id_студента (удалить студента)
- delete all (удалить всех студентов)

## Используемые технологии

- Spring Boot 3
- Gradle 8.5
- Lombok
- JDK 17

## Запуск проекта
Проект можно запустить двумя способами:
1. Запустить Modul2homeworkApplication.java по расположению src/main/java/com/example/modul2homework/Modul2homeworkApplication.java
2. Запустить Dockerfile 
```shell
docker build -f Dockerfile -t my-spring-shell-image .
```
```shell
docker run -it -p 5432:5432 my-spring-shell-image
```
