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
                if(birthdayNoteArrayList.get(i).getDate().getDayOfYear()<
                        birthdayNoteArrayList.get(i-1).getDate().getDayOfYear()){
                    swapByIndex(i,i-1);
                    needMoreLoop = true;
                }
            }
        }
    }

    public void swapByIndex(int index1, int index2){
        BirthdayNote temp = birthdayNoteArrayList.get(index1);
        birthdayNoteArrayList.set(index1,birthdayNoteArrayList.get(index2));
        birthdayNoteArrayList.set(index2,temp);

    }

    public BirthdayNote findByName(String name){
        for(BirthdayNote birthdayNote : birthdayNoteArrayList){
            if (birthdayNote.getName().equalsIgnoreCase(name)){
                return birthdayNote; // если имена одинаковые, вернёт первого в списке
            }
        }
        return null;
    }

    public boolean isEmpty(){
        return birthdayNoteArrayList.isEmpty();
    }
    
    public void printNearBirthday(){
        if (birthdayNoteArrayList.isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        boolean finded = false;
        BirthdayNote nearBirthdayNote = findEarlyBirthday();
        for (BirthdayNote birthdayNote : birthdayNoteArrayList){
            if (birthdayNote.getDate().getDayOfYear() == LocalDate.now().getDayOfYear())
            {
                System.out.println("Ближайшее день рождения сегодня!");
                System.out.println(birthdayNote);
                return;
            }
            if (birthdayNote.getDate().getDayOfYear()>LocalDate.now().getDayOfYear()){
                if (birthdayNote.getDate().getDayOfYear() - LocalDate.now().getDayOfYear() <=
                        nearBirthdayNote.getDate().getDayOfYear() - LocalDate.now().getDayOfYear()){
                    nearBirthdayNote = birthdayNote;
                    System.out.println("Ближайший день рождения - " + nearBirthdayNote.getDate().toString() + " числа");
                    System.out.println(nearBirthdayNote);
                    finded = true;
                }
            }
        }
        if (!finded) {
            for (BirthdayNote birthdayNote : birthdayNoteArrayList){
                if (birthdayNote.getDate().getDayOfYear() <=
                        nearBirthdayNote.getDate().getDayOfYear()){
                    nearBirthdayNote = birthdayNote;
                    System.out.println("Ближайшин день рождения - " + nearBirthdayNote.getDate().toString() + " числа");
                    System.out.println(nearBirthdayNote);
                }
            }
        }
    }
    private BirthdayNote findEarlyBirthday(){
        BirthdayNote result = birthdayNoteArrayList.get(0);
        for (BirthdayNote birthdayNote : birthdayNoteArrayList){
            if(birthdayNote.getDate().getDayOfYear() < result.getDate().getDayOfYear())
                result = birthdayNote;
        }
        return result;
    }

}
