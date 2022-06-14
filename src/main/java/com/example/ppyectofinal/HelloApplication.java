package com.example.ppyectofinal;

import com.example.database.ConnectionDb;
import com.example.database.CrudInsert;
import com.example.database.CrudSelecteProductos;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        ConnectionDb connectionDb = new ConnectionDb();
        Connection con= connectionDb.conectar();
        CrudInsert insert = new CrudInsert(con);
        //insert.insertarPr("garbanzo",10,"2023-3-22",3500.22f);
        //insert.insertarUs(15457413,"Lsepulv","sdea","Luis");
        CrudSelecteProductos productos =new CrudSelecteProductos(con);
        //productos.filtro(true,"vencimiento");
        productos.search("5","cantidad");
        //launch();
    }
}