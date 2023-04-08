package gui.client_fx;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * La classe View contient l'interface du GUI, leas actions qui s'y rattachent et la methode main.
 */
public class View extends Application {

    /**
     * La classe start defini tout l'interface usager avec javaFX et les actions qui s'y rattachent
     * @param stage Le parametre stage est un parametre par defaut de java Fx.
     */
    @Override
    public void start(Stage stage) {

        SplitPane splitPane = new SplitPane();
        StackPane leftPane = new StackPane();
        StackPane rightPane = new StackPane();



        // left Pane
        BorderPane courseList = new BorderPane();
        courseList.setStyle("-fx-background-color: BEIGE");


                // Top
                Label courseListTitle = new Label("Liste des Cours");
                courseListTitle.setFont(new Font("Times New Roman", 30));

                HBox courseListTitleBox = new HBox();
                courseListTitleBox.setPadding(new Insets(15,15,15,15));

                courseListTitleBox.getChildren().add(courseListTitle);
                courseListTitleBox.setAlignment(Pos.TOP_CENTER);

                courseList.setTop(courseListTitleBox);


                // Middle
                TableView courseTable = new TableView<String>();



                TableColumn firstColumn = new TableColumn("Code");
                firstColumn.setCellValueFactory(new PropertyValueFactory<>("code"));

                TableColumn secondColumn = new TableColumn("Cours");
                secondColumn.setCellValueFactory(new PropertyValueFactory<>("name"));


                courseTable.getColumns().addAll(firstColumn, secondColumn);

                courseTable.setEditable(true);

                firstColumn.prefWidthProperty().bind(courseTable.widthProperty().multiply(0.3));
                secondColumn.prefWidthProperty().bind(courseTable.widthProperty().multiply(0.7));


                courseTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

                HBox courseTableBox = new HBox();
                courseTableBox.setPadding(new Insets(10,30,10,30));


                courseTableBox.getChildren().add(courseTable);
                courseList.setCenter(courseTableBox);

                courseTableBox.setAlignment(Pos.CENTER);


                //Bottom
                HBox buttonsBox = new HBox();
                buttonsBox.setSpacing(50.0);
                Button loadButton = new Button("Charger");

                Label sessionLabel = new Label("Chosir une Session");
                MenuItem menuItem1 = new MenuItem("Automne");
                MenuItem menuItem2 = new MenuItem("Hiver");
                MenuItem menuItem3 = new MenuItem("Ete");

                MenuButton sessionDropDown = new MenuButton("",sessionLabel);
                sessionDropDown.getItems().addAll(menuItem1, menuItem2,menuItem3);

                menuItem1.setOnAction((event)->{
                    sessionLabel.setText(menuItem1.getText());
                    });

                    menuItem2.setOnAction((event)->{
                    sessionLabel.setText(menuItem2.getText());
                    });

                    menuItem3.setOnAction((event)->{
                    sessionLabel.setText(menuItem3.getText());
                    });

                buttonsBox.getChildren().add(sessionDropDown);
                buttonsBox.getChildren().add(loadButton);

                buttonsBox.setPadding(new Insets(15,15,15,15));

                courseList.setBottom(buttonsBox);
                buttonsBox.setAlignment(Pos.TOP_CENTER);




        // Right Pane
        BorderPane registrationPane = new BorderPane();
        registrationPane.setStyle("-fx-background-color: BEIGE");


                // Top
                Label registrationPaneTitle = new Label("Formulaire d'Inscription");
                registrationPaneTitle.setFont(new Font("Times New Roman", 30));

                HBox registrationPaneTitleBox = new HBox();
                registrationPaneTitleBox.setPadding(new Insets(15,15,60,15));

                registrationPaneTitleBox.getChildren().add(registrationPaneTitle);
                registrationPaneTitleBox.setAlignment(Pos.TOP_CENTER);

                registrationPane.setTop(registrationPaneTitleBox);



                // Middle
                VBox registrationForm = new VBox();


                HBox firstNameBox = new HBox();
                Text prenomText = new Text("Prenom");
                TextField prenomTextField = new TextField ();
                firstNameBox.setPadding(new Insets(5,5,5,5));
                HBox firstNameText = new HBox();
                firstNameText.getChildren().add(prenomText);
                firstNameText.setPrefWidth(70);
                firstNameBox.getChildren().addAll(firstNameText,prenomTextField);
                firstNameBox.setSpacing(30);
                firstNameBox.setAlignment(Pos.CENTER);
                firstNameBox.setPrefWidth(200);
                registrationForm.getChildren().add(firstNameBox);


                HBox lastNameBox = new HBox();
                Text nomText = new Text("Nom");
                TextField nomTextField = new TextField ();
                lastNameBox.setPadding(new Insets(5,5,5,5));
                HBox lastNameText = new HBox();
                lastNameText.getChildren().add(nomText);
                lastNameText.setPrefWidth(70);
                lastNameBox.getChildren().addAll(lastNameText,nomTextField);
                lastNameBox.setSpacing(30);
                lastNameBox.setAlignment(Pos.CENTER);
                lastNameBox.setPrefWidth(200);
                registrationForm.getChildren().add(lastNameBox);


                HBox emailBox = new HBox();
                Text emailText = new Text("Email");
                TextField emailTextField = new TextField ();
                emailBox.setPadding(new Insets(5,5,5,5));
                HBox mailText = new HBox();
                mailText.getChildren().add(emailText);
                mailText.setPrefWidth(70);
                emailBox.getChildren().addAll(mailText,emailTextField);
                emailBox.setSpacing(30);
                emailBox.setAlignment(Pos.CENTER);
                emailBox.setPrefWidth(200);
                registrationForm.getChildren().add(emailBox);


                HBox matriculeBox = new HBox();
                Text matriculeText = new Text("Matricule");
                TextField matriculeTextField = new TextField ();
                matriculeBox.setPadding(new Insets(5,5,5,5));
                HBox matriculeTextBox = new HBox();
                matriculeTextBox.getChildren().add(matriculeText);
                matriculeTextBox.setPrefWidth(70);
                matriculeBox.getChildren().addAll(matriculeTextBox,matriculeTextField);
                matriculeBox.setSpacing(30);
                matriculeBox.setAlignment(Pos.CENTER);
                matriculeBox.setPrefWidth(200);
                registrationForm.getChildren().add(matriculeBox);


                Button submitButton = new Button("Submit");
                HBox submitButtonBox = new HBox();
                submitButtonBox.getChildren().add(submitButton);
                registrationForm.getChildren().add(submitButtonBox);
                submitButtonBox.setAlignment(Pos.CENTER);


                registrationPane.setCenter(registrationForm);



        leftPane.getChildren().add(courseList);
        rightPane.getChildren().add(registrationPane);

        splitPane.getItems().addAll(leftPane,rightPane);

        AnchorPane pane = new AnchorPane();

        AnchorPane.setTopAnchor(splitPane,10.0);
        AnchorPane.setBottomAnchor(splitPane,10.0);
        AnchorPane.setLeftAnchor(splitPane,10.0);
        AnchorPane.setRightAnchor(splitPane,10.0);

        pane.getChildren().addAll(splitPane);
        pane.setStyle("-fx-background-color: GREY");

        Scene scene = new Scene(pane, 300,200);
        stage.setTitle("Inscription UdeM");
        stage.setScene(scene);
        stage.show();




        // Events

        loadButton.setOnAction((event ->{
            courseTable.getItems().clear();
            ArrayList<ArrayList<String>> coursesLoaded = Controller.loadSession(sessionLabel.getText());
            System.out.println(coursesLoaded);

            for(int i =0;i<coursesLoaded.get(0).size();i++){

                Course cours = new Course(coursesLoaded.get(1).get(i),
                        coursesLoaded.get(0).get(i),sessionLabel.getText());
                courseTable.getItems().add(cours);
            }
        }));

        submitButton.setOnAction((actionEvent -> {

            Object objet = courseTable.getSelectionModel().getSelectedItem();
            String courseCode;

            if ((objet = courseTable.getSelectionModel().getSelectedItem()) == null){
                Alert classSelectionFail = new Alert(Alert.AlertType.ERROR);
                classSelectionFail.setTitle("Impossible de proceder avec l'inscription");
                classSelectionFail.setContentText("Veuillez d'abord choisir un cours");
                classSelectionFail.show();
                return;
            }
            else{
                Course cours = (Course) objet;
                courseCode = cours.getCode();
            }

            System.out.println(courseCode);

            ArrayList<String> registerInfo = new ArrayList<>();
            registerInfo.add("");
            registerInfo.add("");
            registerInfo.add("");
            registerInfo.add("");
            registerInfo.add("");

            int insciptionController = 1;

            boolean inscription = true;

            while(inscription == true){

                // Le switch ici est tres redondant. l'idee est de pouvoir passser d'une etape
                // (case) au porchain SANS avoir recours au serveur avant le case 5 (validation).
                switch(insciptionController){


                    case 1:

                        String firstName = prenomTextField.getText();

                        if(Model.checkFirstname(firstName) == true) {
                            System.out.println("FirstNameOK");
                            registerInfo.set(0,firstName);
                            System.out.println(registerInfo);
                            insciptionController = 2;
                            break;
                        }

                        else{
                            Alert firstNameFail = new Alert(Alert.AlertType.ERROR);
                            firstNameFail.setTitle("Impossible de proceder avec l'inscription");
                            firstNameFail.setContentText("Prenom Incorrect");
                            firstNameFail.show();
                            return;
                        }
                    case 2:

                        String lastname = nomTextField.getText();

                        if(Model.checkLastName(lastname) == true) {
                            System.out.println("LastNameOK");
                            registerInfo.set(1,lastname);
                            System.out.println(registerInfo);
                            insciptionController = 3;
                            break;
                        }

                        else{
                            Alert lastNameFail = new Alert(Alert.AlertType.ERROR);
                            lastNameFail.setTitle("Impossible de proceder avec l'inscription");
                            lastNameFail.setContentText("Nom Incorrect");
                            lastNameFail.show();
                            return;
                        }
                    case 3:

                        String userEmail = emailTextField.getText();

                        if(Model.checkEmail(userEmail) == true) {
                            System.out.println("userEmailOK");
                            registerInfo.set(2,userEmail);
                            System.out.println(registerInfo);
                            insciptionController = 4;
                            break;
                        }

                        else{
                            Alert emailFail = new Alert(Alert.AlertType.ERROR);
                            emailFail.setTitle("Impossible de proceder avec l'inscription");
                            emailFail.setContentText("Email Incorrect");
                            emailFail.show();
                            return;
                        }
                    case 4:
                        String userMatricule = matriculeTextField.getText();

                        if(Model.checkMatricule(userMatricule) == true) {
                            System.out.println("userMatriculeOK");
                            registerInfo.set(3,userMatricule);
                            System.out.println(registerInfo);
                            insciptionController = 5;
                            break;
                        }

                        else{
                            System.out.println("userMatriculeFAil");
                            Alert matriculeFail = new Alert(Alert.AlertType.ERROR);
                            matriculeFail.setTitle("Impossible de proceder avec l'inscription");
                            matriculeFail.setContentText("Matricule Incorrect");
                            matriculeFail.show();
                            return;
                        }

                    case 5:

                            registerInfo.set(4,courseCode);
                            System.out.println(registerInfo);
                            insciptionController = 6;
                            break;


                    case 6:

                        try {
                            String localHostIP = "127.0.0.1";
                            int port = 1337;

                            // Initialize Socket
                            Socket socket = new Socket(localHostIP, port);
                            //System.out.println("Socket Open");

                            //Object Input/Output Initialized
                            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

                            oos.writeObject("INSCRIRE");
                            oos.flush();

                            System.out.println("Handle Registration CMD Sent");

                            String RegInfString = registerInfo.get(0)+","+registerInfo.get(1)+","+
                                    registerInfo.get(2)+","+registerInfo.get(3)+","+
                                    registerInfo.get(4);

                            oos.writeObject(RegInfString);
                            insciptionController = 7;


                            Object objetOOS;

                            if((objetOOS = ois.readObject().toString()) != null){

                                Alert registrationOutcome = new Alert(Alert.AlertType.INFORMATION);
                                registrationOutcome.setTitle("Inscription");
                                registrationOutcome.setContentText((String) objetOOS);
                                registrationOutcome.show();

                                socket.close();
                            }
                        }
                        catch(Exception e){
                            System.out.println("Impossible de joindre le serveur");
                        }

                        inscription = false;
                        break;
                }
            }
        }));
    }

    /**
     * la Methode Main ici ne fait que lancer l'interface usager GUI. si on quitte l'interafce on termine le programme
     * @param args args est un parametre par defaut de la methode Main. le programme ne prend pas d'arguments
     */
    public static void main(String[] args) {
        launch();
    }
}