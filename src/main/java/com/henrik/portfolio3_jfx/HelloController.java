package com.henrik.portfolio3_jfx;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

import java.sql.SQLException;

public class HelloController {
    String url = "jdbc:sqlite:C:\\Users\\Henrik Riskær\\IdeaProjects\\Portfolio_3\\data.db";
    @FXML
    public void pickAisha() throws ClassNotFoundException {
        studentQuery("1");
    }
    @FXML
    public void pickAnya() throws ClassNotFoundException {
        studentQuery("2");
    }
    @FXML
    public void pickAlfred() throws ClassNotFoundException {
        studentQuery("3");
    }
    @FXML
    public void pickBerta() throws ClassNotFoundException {
        studentQuery("4");
    }
    @FXML
    public void pickAlbert() throws ClassNotFoundException {
        studentQuery("5");
    }
    @FXML
    public void pickEske() throws ClassNotFoundException {
        studentQuery("6");
    }
    @FXML
    public void pickOlaf() throws ClassNotFoundException {
        studentQuery("7");
    }
    @FXML
    public void pickSalma() throws ClassNotFoundException {
        studentQuery("8");
    }
    @FXML
    public void pickTheis() throws ClassNotFoundException {
        studentQuery("9");
    }
    @FXML
    public void pickJanet() throws ClassNotFoundException {
        studentQuery("10");
    }

    @FXML
    public void pickSD2019Autumn() throws ClassNotFoundException {
        courseQuery("1");
    }
    @FXML
    public void pickSD2020Spring() throws ClassNotFoundException {
        courseQuery("2");
    }
    @FXML
    public void pickES12020Autumn() throws ClassNotFoundException {
        courseQuery("3");
    }
    @FXML
    protected void studentQuery(String id) throws ClassNotFoundException{

        try {
            System.out.println("Attempting database connection...");
            DataConnection DC = new DataConnection(this.url);
            System.out.println("Database connection successful!");
            DC.pickStudent(id);
            DC.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
    protected void courseQuery(String id) throws ClassNotFoundException{

        try {
            System.out.println("Attempting database connection...");
            DataConnection DC = new DataConnection(this.url);
            System.out.println("Database connection successful!");
            DC.pickCourse(id);
            DC.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}