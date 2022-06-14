package com.example.database;

import java.sql.*;

public class CrudInsert {


    private Connection conexionDb ;

    public CrudInsert(Connection conexionDb) {
        this.conexionDb = conexionDb;
    }

    public void insertarPr(String name, int cantidad, String fechaVencimiento, float precio){
        String sql = "INSERT INTO public.productos(\n" +
                "\t name, cantidad, precio, vencimiento)\n" +
                "\tVALUES ( ?, ?, ?, ?);";

        try{
            PreparedStatement statement = this.conexionDb.prepareStatement(sql);
            statement.setString(1,name);
            statement.setInt(2,cantidad);
            statement.setFloat(3,precio);
            statement.setDate(4,Date.valueOf(fechaVencimiento));
            int rowInsertd = statement.executeUpdate();
            System.out.println((rowInsertd>0)?"inserccion exitosa!":"inserccion fallida!");
        }catch (SQLException e){
            System.out.println("error al conectarse: "+e);
        }
    }

    public void insertarUs(int documento, String user, String pass, String name){
        try {
            String sql ="INSERT INTO public.usuarios(\n" +
                    "\tid, usuario, password, name)\n" +
                    "\tVALUES (?, ?, ?, ?);";
            PreparedStatement statement = conexionDb.prepareStatement(sql);
            statement.setInt(1,documento);
            statement.setString(2,user);
            statement.setString(3,pass);
            statement.setString(4,name);
            int rowInserted=statement.executeUpdate();
            System.out.println((rowInserted>0)?"inserccion exitosa!":"inserccion fallida!");
        }catch (SQLException e){
            System.out.println(e);
        }

    }


}
