package org.example;
import database.DBConnection;
import java.sql.Connection;
public class Main { public static void main(String[] args){ Connection conn=DBConnection.getConnection(); System.out.println(conn!=null?"Connection Successful!":"Connection Failed!"); } }
