# Проект "ToDo" (В процессе разработки)

* [Описание](#описание)
* [Функционал](#функционал)
* [Технологии](#технологии)
* [Требования к окружению](#требования-к-окружению)
* [Запуск](#запуск)
* [Интерфейс](#интерфейс)
* [Автор](#автор)

## Описание

MVC REST API - приложение, todo-список дел.

## Функционал

* Вывод всех задач;
* Вывод только незавершённых задач;
* Добавление задачи в todo-list;
* Редактирование задач;
* Хранение данных в БД PostgreSQL:

## Технологии

* Java 17 LTS;
* Spring boot;
* PostgreSQL 15;
* Hibernate 5;
* Apache Tomcat Server 9;
* Thymeleaf;
* HTML, Bootstrap 5;
* Log4j;
* Maven;
* Liquibase.

## Требования к окружению
* Java 17 LTS;
* PostgreSQL 15.1;
* Apache Maven 3.8.4;

## Запуск
Для локального запуска проекта необходимо:
- Клонировать репозиторий;
- Создать базу данных PostgresSQL:
```sql
CREATE DATABASE todo;
```
- Подгрузить необходимые зависимости через Maven

## Интерфейс

* Список всех задач
  ![Screenshot](screenshots/showAllTask.png)

* Создание задачи
  ![Screenshot](screenshots/addTask.png)

* Редактирование задачи
  ![Screenshot](screenshots/editTask.png)

## Автор

Michael Zalogin

zaloginmiha@gmail.com

+79111480757