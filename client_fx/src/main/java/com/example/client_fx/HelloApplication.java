package com.example.client_fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        VBox leVBox = new VBox();
        Scene scene = new Scene(leVBox, 320, 240);

        Text letext = new Text("Sup FAm"    );

        leVBox.getChildren().add(letext);


        Button leBoutonduNini = new Button("CLiquez sur le Bouton du Nini");


        leVBox.getChildren().add(leBoutonduNini);


        leBoutonduNini.setOnMouseClicked((actionEvent -> {

            System.out.println(actionEvent.getX());


        }));



        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}