package org.birthdayreminder;

import java.time.LocalDate;
import java.util.Objects;

public class BirthdayNote {
    private String name;
    private LocalDate date;
    public BirthdayNote (){
        name = "Без имени";
        date = LocalDate.of(1900, 1, 1);
    }
    public BirthdayNote(String name, LocalDate date){
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BirthdayNote that = (BirthdayNote) o;
        return name.equals(that.name) && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date);
    }

    @Override
    public String toString() {
        return "ФИО: " + name + ", " + date.toString();
    }
}
