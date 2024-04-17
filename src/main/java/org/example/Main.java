package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws SQLException {
        // example0();
       // example1();
        //example2();
        example3();

    }

    private static void example3() throws SQLException {
        Connection conn = connectToDBTre();
        ArrayList<Triangle> triang = new ArrayList<>();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM public.\"Triangle\"");
        double srP=0;
        while (rs.next()) {
            int a = rs.getInt("a");
            int b = rs.getInt("b");
            int c = rs.getInt("c");
            triang.add(new Triangle(a, b, c));
            srP+=(a+b+c);
        }
        srP = srP/triang.size();
        System.out.println("средний периметр: "+srP);
    }

    private static void example2() throws SQLException {
        Connection conn = connectToDB();
        ArrayList<User> users = loadUsers(conn);
        System.out.println("получен список из "+users.size()+" юзеров");
        users.forEach(System.out::println);

        conn.close();
    }

    public static ArrayList<User> loadUsers(Connection conn) throws SQLException {
        ArrayList<User> users=new ArrayList<>();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM public.user");
        while (rs.next()) {
            int x = rs.getInt("id");
            String fio = rs.getString("fio");
            double m = rs.getDouble("money");
            users.add(new User(x, fio, m));
        }
        rs.close();
        st.close();
        return users;
    }

    private static void example1() throws SQLException {
        Connection conn = connectToDB();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM public.user");
        while (rs.next()) {
            int x = rs.getInt("id");
            String fio = rs.getString("fio");
            double m = rs.getDouble("money");
            System.out.println("получена строка: "+x+" "+fio+" "+m);
        }
        rs.close();
        st.close();
        conn.close();
    }

    public static void example0(){
        String url = "jdbc:postgresql://10.10.104.136:5432/test4";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "123");
        props.setProperty("ssl", "false");
        try {
            Connection conn = DriverManager.getConnection(url, props);
            System.out.println("удалось подключиться к БД test4");
            conn.close();
        }
        catch (SQLException e){
            System.out.println("все пропало");
            e.printStackTrace();
        }
    }

    public static Connection connectToDB(){
        String url = "jdbc:postgresql://10.10.104.136:5432/test4";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "123");
        props.setProperty("ssl", "false");
        try {
            Connection conn = DriverManager.getConnection(url, props);
            return conn;
        }
        catch (SQLException e){
            System.out.println("все пропало");
            e.printStackTrace();
            return null;
        }
    }
    public static Connection connectToDBTre(){
        String url = "jdbc:postgresql://10.10.104.136:5432/Geometry";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "123");
        props.setProperty("ssl", "false");
        try {
            Connection conn = DriverManager.getConnection(url, props);
            return conn;
        }
        catch (SQLException e){
            System.out.println("все пропало");
            e.printStackTrace();
            return null;
        }
    }
}