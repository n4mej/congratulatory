package org.birthdayreminder;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuController {
    public static void save(BirthdayNoteList birthdayNoteList){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сохранение файла:");
        System.out.print("Введите название файла - ");
        String fileName = scanner.nextLine();
        IOController.writer(birthdayNoteList, fileName);

    }
    public static BirthdayNoteList read(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Чтение файла:");
        System.out.print("Введите название файла - ");
        String fileName = scanner.nextLine();
        return IOController.reader(fileName);
    }
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
    public static void find(BirthdayNoteList birthdayNoteList){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Поиск записи по имени:");
        System.out.print("Введите ФИО - ");
        String name = scanner.nextLine();
        BirthdayNote result = birthdayNoteList.findByName(name);
        if (result == null) System.out.println("Ошибка поиска записи! Проверьте правильность ввода ФИО");
        System.out.println(result);
    }
    public static boolean check() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Текущие записи будут удалены(заменены)");
        System.out.print("Продолжить? Да/нет ");
        String result = scanner.nextLine();
        return result.equalsIgnoreCase("да");
    }
}
