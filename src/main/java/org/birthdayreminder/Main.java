package org.birthdayreminder;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BirthdayNoteList birthdayNoteList = new BirthdayNoteList();
        Scanner scanner = new Scanner(System.in);
        int inputMenu;
        do{
            System.out.println("1 - Вывод списка");
            System.out.println("2 - Добавление записи");
            System.out.println("3 - Удаление записи");
            System.out.println("4 - Сортировка");
            System.out.println("5 - Поиск записи по имени");
            System.out.println("6 - Поиск ближайшего дня рождения");
            System.out.println("7 - Сохранение данных в файл");
            System.out.println("8 - Загрузка данных из файла");
            System.out.println("9 - Сохранить записи в базу данных");
            System.out.println("10 - Загрузить записи из базы данных");
            System.out.println("0 - Выход");
            System.out.print("Введите необходимый пункт - ");
            inputMenu = scanner.nextInt();
            switch (inputMenu){
                case 1:
                    birthdayNoteList.print();
                    break;
                case 2:
                    MenuController.add(birthdayNoteList);
                    break;
                case 3:
                    MenuController.delete(birthdayNoteList);
                    break;
                case 4:
                    birthdayNoteList.sort();
                    break;
                case 5:
                    MenuController.find(birthdayNoteList);
                    break;
                case 6:
                    birthdayNoteList.printNearBirthday();
                    break;
                case 7:
                    MenuController.save(birthdayNoteList);
                    break;
                case 8:
                    if(MenuController.check())birthdayNoteList = MenuController.read();
                    break;
                case 9:
                    DatabaseRepository.saveAllToDatabase(birthdayNoteList);
                    break;
                case 10:
                    if(MenuController.check())birthdayNoteList = DatabaseRepository.loadAllFromDatabase();
                    break;
                case 0:
                    DatabaseConnection.closeConnection();
                    return;
            }
        }
        while (true);
    }
}