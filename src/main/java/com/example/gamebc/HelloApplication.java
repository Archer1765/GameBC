package com.example.gamebc;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import tableAtt.TableAttem;

import java.io.IOException;


public class HelloApplication extends Application {
    private ObservableList<TableAttem> data = FXCollections.observableArrayList();
    public ObservableList<TableAttem> getData() {
        return data;
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("/logo.png")));
        //scene.setFill(false);
        stage.setTitle("Быки и коровы");
        stage.setScene(scene);

        //Object attemData;
        //TableView<TableAttem> tableView = new TableView<>();
        //checkNumber
        //HelloController controller = new HelloController();
        //controller.setHelloApplication(this);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}