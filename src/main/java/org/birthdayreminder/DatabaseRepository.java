package org.birthdayreminder;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRepository {
    public static boolean saveAllToDatabase(BirthdayNoteList birthdayNoteList) {
        String clearSql = "DELETE FROM birthdays";
        String insertSql = "INSERT INTO birthdays (full_name, birth_date) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(clearSql);
            }
            try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
                for (BirthdayNote note : birthdayNoteList.getBirthdayNoteArrayList()) {
                    pstmt.setString(1, note.getName());
                    pstmt.setDate(2, Date.valueOf(note.getDate()));
                    pstmt.addBatch();
                }
                int[] results = pstmt.executeBatch();
                conn.commit();

                System.out.println("Данные сохранены в базу данных");
                return true;

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при сохранении в базу данных");
            return false;
        }
    }
    public static BirthdayNoteList loadAllFromDatabase() {
        BirthdayNoteList birthdayNoteList = new BirthdayNoteList();
        String sql = "SELECT full_name, birth_date FROM birthdays ORDER BY birth_date";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            int count = 0;
            while (rs.next()) {
                String name = rs.getString("full_name");
                LocalDate date = rs.getDate("birth_date").toLocalDate();
                birthdayNoteList.add(new BirthdayNote(name, date));
                count++;
            }

            System.out.println("Записи успешно загружены");

        } catch (SQLException e) {
            System.out.println("Ошибка при загрузке из записей из базы данных");
        }

        return birthdayNoteList;
    }
}