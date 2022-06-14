package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDb {
   public Connection conectar(){
       String host="database-1.cwvm1nkqoc9g.us-east-1.rds.amazonaws.com";
       String user="program";
       String pass="unal123";
       String db ="dbnegocio";
       Connection conec=null;
       try {
            try {
                Class.forName("org.postgresql.Driver");

            }catch (ClassNotFoundException e){
                System.out.println("error:"+e);
            }

            conec = DriverManager.getConnection("jdbc:postgresql://"+host+":5432/"+db,user,pass);
            boolean valido = conec.isValid(50000);
           System.out.println(valido?"test ok":"test fail");
       }catch (java.sql.SQLException e){
           System.out.println(e);
       }
       return conec;
   }
   }
