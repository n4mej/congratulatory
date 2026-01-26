# Birthday Reminder (Уровень 2)

Консольное приложение для управления днями рождения с хранением в PostgreSQL.

## Функциональность
- Просмотр всех дней рождения
- Поиск ближайшего дня рождения
- Добавление/удаление/редактирование записей
- Сохранение в БД и файлы

## Запуск
1. Установите PostgreSQL
2. Создайте БД: `CREATE DATABASE testbd;`
3. Настройте `DatabaseConnection.java`
4. `mvn clean compile exec:java`

## Технологии
- Java 17
- PostgreSQL
- JDBC
- Maven