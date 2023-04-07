package gui.client_fx;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class application extends Application {


    @Override
    public void start(Stage stage) throws IOException {

        SplitPane splitPane = new SplitPane();

        StackPane stackPaneLeft = new StackPane();
        StackPane stackPaneRight = new StackPane();













        // left Stack Pane
        BorderPane courseList = new BorderPane();

        Label courseListTitle = new Label("Liste des Cours");
        HBox courseListTitleBox = new HBox();

        courseListTitleBox.getChildren().add(courseListTitle);
        courseListTitleBox.setAlignment(Pos.TOP_CENTER);


        courseList.setTop(courseListTitleBox);


        HBox buttonsBox = new HBox();
        Button loadButton = new Button("Charger");
        buttonsBox.getChildren().add(loadButton);
        courseList.setBottom(buttonsBox);
        buttonsBox.setAlignment(Pos.BOTTOM_CENTER);

















        // Right Stack Pane

        HBox registrationForm = new HBox();
        HBox registrationFormTitle = new HBox();

        Label inscriptionTitle = new Label("Formulaire d'Inscription");

        registrationForm.getChildren().add(inscriptionTitle);
        registrationForm.setAlignment(Pos.TOP_CENTER);




















        registrationForm.getChildren().add(registrationFormTitle);



        stackPaneLeft.getChildren().add(courseList);
        stackPaneRight.getChildren().add(registrationForm);

        splitPane.getItems().addAll(stackPaneLeft,stackPaneRight);

        AnchorPane pane = new AnchorPane();

        AnchorPane.setTopAnchor(splitPane,10.0);
        AnchorPane.setBottomAnchor(splitPane,10.0);
        AnchorPane.setLeftAnchor(splitPane,10.0);
        AnchorPane.setRightAnchor(splitPane,10.0);

        pane.getChildren().addAll(splitPane);
        pane.setStyle("-fx-background-color: BLUE");

        Scene scene = new Scene(pane, 300,200);
        stage.setTitle("Inscription UdeM");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}