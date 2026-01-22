package org.birthdayreminder;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BirthdayNoteList birthdayNoteList = new BirthdayNoteList();
        birthdayNoteList.add(new BirthdayNote("Петров Петр Петрович",
                LocalDate.of(1999,2,2)));
        birthdayNoteList.add(new BirthdayNote("Сидоров Сидор Сидорович",
                LocalDate.of(2002,4,6)));
        birthdayNoteList.add(new BirthdayNote("Иванов Иван Иванович",
                LocalDate.of(2006,6,19)));
        birthdayNoteList.add(new BirthdayNote("Соколова Мария Ивановна",
                LocalDate.of(1998,11,23)));
        birthdayNoteList.add(new BirthdayNote("Близнецов Виктор Эдуардович",
                LocalDate.of(2001,9,11)));
        birthdayNoteList.add(new BirthdayNote("Круглова Лидия Давыдовна",
                LocalDate.of(2004,12,2)));
        birthdayNoteList.add(new BirthdayNote("Сопронова Людмила Егоровна",
                LocalDate.of(1991,8,30)));
        birthdayNoteList.add(new BirthdayNote("Свиридов Петр Геннадиевич",
                LocalDate.of(2005,3,31)));
        Scanner scanner = new Scanner(System.in);
        int inputMenu;
        do{
            System.out.println("1 - Вывод списка");
            System.out.println("2 - Добавление записи");
            System.out.println("3 - Удаление записи");
            System.out.println("4 - Сортировка");
            System.out.println("5 - Поиск записи по имени");
            System.out.println("6 - Поиск ближайшего дня рождения");
            System.out.println("0 - Выход");
            System.out.print("Введите необходимый пункт - ");
            inputMenu = scanner.nextInt();
            switch (inputMenu){
                case 1:
                    birthdayNoteList.print();
                    break;
                case 2:
                    MenuNoteAddition.add(birthdayNoteList);
                    break;
                case 3:
                    MenuNoteDeletion.delete(birthdayNoteList);
                    break;
                case 4:
                    birthdayNoteList.sort();
                    break;
                case 5:

                    break;
                case 6:
                    System.out.println(birthdayNoteList.findNearBirthday());
                    break;
                case 0:
                    return;
            }
        }
        while (true);
    }
}