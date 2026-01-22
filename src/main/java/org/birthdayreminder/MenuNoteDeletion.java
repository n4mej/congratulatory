package org.birthdayreminder;

import java.util.Scanner;

public class MenuNoteDeletion {
    public static void delete(BirthdayNoteList birthdayNoteList){
        if (birthdayNoteList.isEmpty()) {
            System.out.println("Список пуст!");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите полное ФИО: ");
        String answer;
        answer = scanner.nextLine();
        BirthdayNote birthdayNote;
        birthdayNote = birthdayNoteList.findByName(answer);
        System.out.println("Вы хотите удалить запись:");
        System.out.println(birthdayNote.toString());
        System.out.print("Да/нет?");
        answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("да")){
            birthdayNoteList.delete(birthdayNote);
        }
        else{
            System.out.println("Удаление отменено");
        }
    }
}
