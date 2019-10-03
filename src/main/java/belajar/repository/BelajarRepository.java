package belajar.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import belajar.Database;
import belajar.model.Belajar;

public class BelajarRepository {
    public static ArrayList<Belajar> getAll() {
        ArrayList<Belajar> data = new ArrayList<>();
        try {
            ResultSet res = Database
            .getConnection()
            .createStatement()
            .executeQuery("SELECT * FROM BELAJAR");

            while(res.next()) {
                data.add(new Belajar(res.getInt("id"), res.getString("name")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return data;
    }
}