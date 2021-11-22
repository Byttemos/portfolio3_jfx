package com.henrik.portfolio3_jfx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
    public static void main(String[] args) throws ClassNotFoundException{

        launch(args);

        /*String url = "jdbc:sqlite:C:\\Users\\Henrik Riskær\\IdeaProjects\\Portfolio_3\\data.db";
        try {
            System.out.println("Attempting database connection...");
            DataConnection DC = new DataConnection(url);
            System.out.println("Database connection successful!");
            DC.pickCourse("1");
            DC.pickStudent("1");
            DC.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}

