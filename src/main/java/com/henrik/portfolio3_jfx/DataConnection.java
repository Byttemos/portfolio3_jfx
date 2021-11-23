package com.henrik.portfolio3_jfx;
import java.sql.Connection;
import java.sql.SQLException;
//import java.lang.*;

import javafx.collections.ObservableList;
import org.sqlite.JDBC;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import static java.sql.DriverManager.getConnection;



public class DataConnection {
    static Connection conn;
    static String url;

    DataConnection(String url) throws ClassNotFoundException{
        Class.forName("org.sqlite.JDBC");
        try {
            this.url = url;
            this.conn = getConnection(url);
        } catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    public String pickCourse(String course_id){
        try{
            String sql = "SELECT Courses.CourseName, Courses.CourseYear, Courses.CourseSemester" +
                ", AVG(Registrations.Grade) AS Grade " +
                "FROM Courses " + "LEFT JOIN Registrations ON Registrations.CourseID=Courses.ID " +
                "WHERE Courses.ID=" + course_id;
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            String course = "";
            while(rs.next()){
                course = "Course name: " + rs.getString("CourseName") + " " + rs.getString("CourseSemester") +
                                   " " + rs.getString("CourseYear") + "\n" +
                "Grade average: " + rs.getString("Grade");
            }
            return course;
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public String getStudentAvg(String student_id){
        String sql = "SELECT AVG(r.Grade) as Average FROM Registrations r WHERE StudentID=" + student_id;
        try {
            ResultSet rs = this.query(sql).get();
            String student_avg = rs.getString(1);
            return student_avg;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }


    public String pickStudent(String student_id){
        String sql = "SELECT s.name, c.CourseName, c.CourseYear, c.CourseSemester, r.Grade " +
            "FROM Students s LEFT JOIN Registrations r ON r.StudentID=s.ID " +
            "LEFT JOIN Courses c ON c.ID=r.CourseID " +
            "WHERE s.ID=" + student_id;

        try {
            ResultSet rs = this.query(sql).get();

            String out = this.printResult(rs);

           // System.out.println("test: " + test);
            return(out);

        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("SQL error");
        }return null;
    }


    private Optional<ResultSet> query(String query) {
        try{
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return Optional.of(rs);
        }catch(SQLException e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private String printResult(ResultSet rs) {
        try {
            ResultSetMetaData rsmeta = rs.getMetaData();
            int columnCount = rsmeta.getColumnCount();
            System.out.println(columnCount);
            String[] diller;
            diller = new String[columnCount];
            String bob = "";
            while(rs.next()){
                for (int i = 1; i <= columnCount; i++) {

                    String colVal = rs.getString(i);
                    System.out.println(colVal);
                    diller[i-1] = rsmeta.getColumnName(i) + ": " + colVal;

                }
            bob += String.join("\n" ,diller);

            }

            return bob;

        }catch(SQLException e){
            e.printStackTrace();

        }
        return null;
    }

}
