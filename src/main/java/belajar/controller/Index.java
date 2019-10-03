package belajar.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import com.google.gson.Gson;
import belajar.Database;
import belajar.model.Belajar;
import io.micronaut.http.MediaType;

@Controller("/")
public class Index {
    @Get(produces = MediaType.APPLICATION_JSON)
    public String index() throws SQLException {
        ResultSet res = Database
        .getConnection()
        .createStatement()
        .executeQuery("Select * from belajar");
        ArrayList<Belajar> data = new ArrayList<>();
        while (res.next()) {
            data.add(new Belajar(res.getInt("id"), res.getString("name")));
        }
        return (new Gson()).toJson(data);
    }

}