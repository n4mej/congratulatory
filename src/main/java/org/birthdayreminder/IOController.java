package org.birthdayreminder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class IOController {
    public static void writer(BirthdayNoteList birthdayNoteList){
        try(FileWriter fileWriter = new FileWriter("birthdayList.txt")){
            for(BirthdayNote birthdayNote : birthdayNoteList.getBirthdayNoteArrayList()){
                fileWriter.write(birthdayNote.toString());
                fileWriter.write("\n");
            }
            fileWriter.flush();
        }
        catch (IOException e){
            System.out.println("Ошибка записи данных");
        }
    }

    public static BirthdayNoteList reader(){
        BirthdayNoteList birthdayNoteList = new BirthdayNoteList();
        try {
            Path path = Paths.get("birthdayList.txt");
            List<String> lines = Files.readAllLines(path);
            for (String line : lines){
                birthdayNoteList.add(lineToBirthdayNote(line));
            }
        }
        catch (IOException e){
            System.out.println("Ошибка чтения данных");
        }
        return birthdayNoteList;
    }
    private static BirthdayNote lineToBirthdayNote(String line){
        line = line.substring(5);
        String [] splitedLine = line.split(", ");
        String [] splitedDate = splitedLine[1].split("-");
        return new BirthdayNote(splitedLine[0], LocalDate.of(Integer.parseInt(splitedDate[0]),
                Integer.parseInt(splitedDate[1]),
                Integer.parseInt(splitedDate[2])));
    }
}
