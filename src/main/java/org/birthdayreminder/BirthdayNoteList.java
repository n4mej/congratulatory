package org.birthdayreminder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class BirthdayNoteList {
    private ArrayList<BirthdayNote> birthdayNoteArrayList;

    public BirthdayNoteList() {
        birthdayNoteArrayList = new ArrayList<BirthdayNote>();
    }

    public ArrayList<BirthdayNote> getBirthdayNoteArrayList() {
        return birthdayNoteArrayList;
    }

//    public void setBirthdayNoteArrayList(ArrayList<BirthdayNote> birthdayNoteArrayList) {
//        this.birthdayNoteArrayList = birthdayNoteArrayList;
//    }

    public void add(BirthdayNote birthdayNote){
        birthdayNoteArrayList.add(birthdayNote);
//        System.out.println("Запись успешно добавлена!");
    }

//    public void add(String name, int year, int month, int day) {
//        birthdayNoteArrayList.add(new BirthdayNote(name, LocalDate.of(year, month, day)));
//        System.out.println("Запись успешно добавлена!");
//    }

    public void delete(BirthdayNote birthdayNote){
        try {
            birthdayNoteArrayList.remove(birthdayNote);
//            System.out.println("Запись успешно удалена!");
        }
        catch (ConcurrentModificationException e){
            System.out.println("Ошибка удаления записи!");
        }
    }

    public void print(){
        if (birthdayNoteArrayList.isEmpty()){
            System.out.println("Список пуст");
            return;
        }
        for(BirthdayNote birthdayNote : birthdayNoteArrayList){
            System.out.println(birthdayNote);
        }
    }

    public void sort(){
        boolean needMoreLoop = true;
        while (needMoreLoop){
            needMoreLoop = false;
            for(int i=1; i<birthdayNoteArrayList.size(); i++){
//                System.out.println(birthdayNoteArrayList.get(i).getDate().getDayOfYear());
//                System.out.println(birthdayNoteArrayList.get(i-1).getDate().getDayOfYear());
                if(birthdayNoteArrayList.get(i).getDate().getDayOfYear()<
                        birthdayNoteArrayList.get(i-1).getDate().getDayOfYear()){
                    swapByIndex(i,i-1);
                    needMoreLoop = true;
                }
            }
        }
    }

    public void swapByIndex(int index1, int index2){
//        System.out.println("Меняем "+index1+" с "+index2);
//        System.out.println("-ДО-");
//        System.out.println(birthdayNoteArrayList.get(index1));
//        System.out.println(birthdayNoteArrayList.get(index2));
//        System.out.println("-ПОСЛЕ-");
        BirthdayNote temp = birthdayNoteArrayList.get(index1);
        birthdayNoteArrayList.set(index1,birthdayNoteArrayList.get(index2));
        birthdayNoteArrayList.set(index2,temp);
//        System.out.println(birthdayNoteArrayList.get(index1));
//        System.out.println(birthdayNoteArrayList.get(index2));
//        System.out.println("----");

    }

    public BirthdayNote findByName(String name){
        for(BirthdayNote birthdayNote : birthdayNoteArrayList){
            if (birthdayNote.getName().equalsIgnoreCase(name)){
                return birthdayNote; // если имена одинаковые, вернёт первого в списке
            }
        }
        return null;
    }

//    public void deleteByName(String name){
//        delete(findByName(name));
//    }

    public boolean isEmpty(){
        return birthdayNoteArrayList.isEmpty();
    }
    
    public BirthdayNote findNearBirthday(){
        if (birthdayNoteArrayList.isEmpty()) {
            System.out.println("Список пуст");
            return null;
        }
        BirthdayNote nearBirthdayNote = birthdayNoteArrayList.get(0);
        for (BirthdayNote birthdayNote : birthdayNoteArrayList){
            if (birthdayNote.getDate().getDayOfYear() == LocalDate.now().getDayOfYear())
            {
                System.out.println("Ближайшее день рождения сегодня!");
                return birthdayNote;
            }
            if (birthdayNote.getDate().getDayOfYear()>LocalDate.now().getDayOfYear()){
                if (birthdayNote.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() <
                        nearBirthdayNote.getDate().getDayOfYear() - LocalDate.now().getDayOfYear()){
                    nearBirthdayNote = birthdayNote;
                }
            }
        }
        return nearBirthdayNote;
    }


}
