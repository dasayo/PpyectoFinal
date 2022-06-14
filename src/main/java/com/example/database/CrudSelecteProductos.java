package com.example.database;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudSelecteProductos {
    private Connection connection;

    public CrudSelecteProductos(Connection connection) {
        this.connection = connection;
    }

    public void allProducts(){
        String sql = "select * from productos;";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int cantidad = resultSet.getInt(3);
                float precio = resultSet.getFloat(4);
                String vencimiento = String.valueOf(resultSet.getDate(5));
                System.out.println(""+id+"---"+name+"---"+cantidad+"---"+precio+"---"+vencimiento);
            }
        }catch (SQLException e){
            System.out.println(e);
        }

    }

    public void filtro(boolean check, String column){

        switch (column){
            case "id":
            case "name":
            case "precio":
            case "cantidad":
            case "vencimiento":
                String sql = check?"SELECT * FROM productos ORDER BY "+column+" ASC;":"SELECT * FROM productos ORDER BY "+
                        column+" DESC;";
                try {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);
                    while (resultSet.next()){
                        int id = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        int cantidad = resultSet.getInt(3);
                        float precio = resultSet.getFloat(4);
                        String vencimiento = String.valueOf(resultSet.getDate(5));
                        System.out.println(""+id+"---"+name+"---"+cantidad+"---"+precio+"---"+vencimiento);
                    }
                }catch (SQLException e){
                    System.out.println(e);
                }
                break;
            default:
                System.out.println("no se ingreso una columna valida");
        }
    }

    public void search(String busqueda, String column){
        switch (column) {
            case "id":
            case "name":
            case "precio":
            case "cantidad":
            case "vencimiento":
                String sqlStatement = "SELECT * FROM productos WHERE " + column + "=" + busqueda + ";";
                try {
                    Statement statement = connection.createStatement();
                    ResultSet resultado = statement.executeQuery(sqlStatement);
                    while (resultado.next()){
                        int id = resultado.getInt(1);
                        String name = resultado.getString(2);
                        int cantidad = resultado.getInt(3);
                        float precio = resultado.getFloat(4);
                        String vencimiento = String.valueOf(resultado.getDate(5));
                        System.out.println(""+id+"---"+name+"---"+cantidad+"---"+precio+"---"+vencimiento);
                    }
                }catch (SQLException e){
                    System.out.println(e);
                }
                break;
            default:
                System.out.println("columna no valida");
        }
    }

}
