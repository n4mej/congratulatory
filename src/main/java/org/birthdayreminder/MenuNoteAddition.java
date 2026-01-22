package org.birthdayreminder;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuNoteAddition {
    public static void add(BirthdayNoteList birthdayNoteList){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Введите ФИО: ");
        String inputName = scanner2.nextLine();
        System.out.print("Введите год рождения: ");
        int inputBirthdayYear = scanner.nextInt();
        System.out.print("Введите месяц рождения: ");
        int inputBirthdayMonth = scanner.nextInt();
        System.out.print("Введите день рождения: ");
        int inputBirthdayDay = scanner.nextInt();
        birthdayNoteList.add
                (new BirthdayNote(inputName,
                        LocalDate.of(inputBirthdayYear, inputBirthdayMonth, inputBirthdayDay)));
    }
}
