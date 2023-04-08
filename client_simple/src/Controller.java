import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {

        // Socket (THIS BELONGS IN MODEL!!!!!!)
        String localHostIP = "127.0.0.1";
        int    port        =  1337;

        // Opens the Scanner
        Scanner sc  = new Scanner(System.in);


        //Initialise la variable connectionTracker qui agit comme "variable-controlleur" du programme
        int connectionTracker = 0;

        boolean programRunning = true;

        while(programRunning == true) {

            try {
                Socket socket = new Socket(localHostIP, port);
                System.out.println("Socket Open");


                //Object Input/Output Initialized
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());


                // "connected" permet de deconnecter le socket pour "reset" oos et ois et d'eviter les
                // EOFExceptions cote serveur. Ainsi; On se deconnecte-et-reconnecte au serveur que pour effectuer
                // une nouvelle commande ET circuler entre les differents menus.
                boolean connected = true;
                while (connected) {


                    switch (connectionTracker) {

                        // Ecran de Bienvenue
                        case 0:

                            View.commandLineprint(View.welcomeText);

                            connectionTracker = 1;
                            break;

                        //Menu de Chargement
                        case 1:

                            View.commandLineprint(View.sessionSelection);
                            View.promptUserChoice();
                            //Scanner In
                            String arg = sc.nextLine();
                            //sc.nextLine();

                            //
                            if (View.sessions.contains(arg) == true) {
                                //System.out.println(Model.sessions.contains(arg));
                                oos.writeObject(Model.loadCoursesCMD(arg));
                                oos.flush();
                                connectionTracker = 2;

                            } else {
                                View.selectionError();
                            }
                            break;

                        // Page de Selection de cours
                        case 2:

                            try {

                                ArrayList<ArrayList<String>> courselist = Model.objectToCourseList(ois.readObject());

                                View.displayCourseList(courselist);

                                connectionTracker = 3;

                            } catch (IOException | ClassNotFoundException e) {
                                System.out.println("Impossible de rejoindre le serveur");
                                connected = false;
                                programRunning = false;
                            }
                            //connected =false;
                            break;


                        // Page d'Inscription
                        case 3:

                            View.courseListDisplayOptions();
                            View.promptUserChoice();

                            String userSelection = "";
                            userSelection = sc.nextLine();

                            switch(userSelection){

                                case "1":

                                    connectionTracker = 1;
                                    connected = false;

                                    break;

                                case "2":

                                    connectionTracker = 4;
                                    connected = false;
                                    break;

                                default:
                                    View.selectionError();
                                    break;

                        }
                        break;


                        // Inscription
                        case 4:

                            /*********
                             *
                             *
                             *
                             * Modify registerInfo to be a String[] ONLYYYYYYY
                             *
                             *
                             *
                             *
                             *
                             */



                            // Here I am forced to initialize the ArrayList with empty values to prevent using
                            // registerInfo.add("Strirng")
                            ArrayList<String> registerInfo = new ArrayList<>();
                            registerInfo.add("");
                            registerInfo.add("");
                            registerInfo.add("");
                            registerInfo.add("");
                            registerInfo.add("");

                            // Cette structure permet de conserver les infos deja entrees par l'utilisateur
                            int insciptionController = 0;

                            boolean inscription = true;

                                while(inscription == true){

                                    // Le switch ici est tres redondant. l'idee est de pouvoir passser d'une etape
                                    // (case) au porchain SANS avoir recours au serveur avant le case 5 (validation).
                                    switch(insciptionController){

                                        case 0:
                                            View.welcomeRegisterMenu();
                                            insciptionController = 1;
                                            break;

                                        case 1:

                                        View.promptUserFisrtName();
                                        String firstName = sc.nextLine();

                                        if(Model.checkFirstname(firstName) == true) {
                                            System.out.println("FirstNameOK");
                                            registerInfo.set(0,firstName);
                                            System.out.println(registerInfo);
                                            insciptionController = 2;
                                            break;
                                        }

                                        else{
                                            System.out.println("FirstNameFail");
                                            View.userInputValidationFail();
                                            break;
                                        }
                                        case 2:

                                            View.promptUserLastName();
                                            String lastname = sc.nextLine();

                                            if(Model.checkLastName(lastname) == true) {
                                                System.out.println("LastNameOK");
                                                registerInfo.set(1,lastname);
                                                System.out.println(registerInfo);
                                                insciptionController = 3;
                                                break;
                                            }

                                            else{
                                                System.out.println("LastNameFail");
                                                View.userInputValidationFail();
                                                break;
                                            }
                                        case 3:

                                            View.promptUserEmail();
                                            String userEmail = sc.nextLine();

                                            if(Model.checkEmail(userEmail) == true) {
                                                System.out.println("userEmailOK");
                                                registerInfo.set(2,userEmail);
                                                System.out.println(registerInfo);
                                                insciptionController = 4;
                                                break;
                                            }

                                            else{
                                                System.out.println("userEmailFail");
                                                View.userInputValidationFail();
                                                break;
                                            }
                                        case 4:

                                            View.promptUserMatricule();
                                            String userMatricule = sc.nextLine();

                                            if(Model.checkMatricule(userMatricule) == true) {
                                                System.out.println("userMatriculeOK");
                                                registerInfo.set(3,userMatricule);
                                                System.out.println(registerInfo);
                                                insciptionController = 5;
                                                break;
                                            }

                                            else{
                                                System.out.println("userMatriculeFAil");
                                                View.userInputValidationFail();
                                                break;
                                            }

                                        case 5:

                                            View.promptUserCourseCode();
                                            String courseCode = sc.nextLine();

                                            if(Model.checkCourseCode(courseCode) == true) {
                                                System.out.println("courseCodeOK");
                                                registerInfo.set(4,courseCode);
                                                System.out.println(registerInfo);
                                                insciptionController = 6;
                                                break;
                                            }

                                            else{
                                                System.out.println("courseCodeFail");
                                                View.userInputValidationFail();
                                                break;
                                            }

                                        case 6:

                                            oos.writeObject("INSCRIRE");
                                            oos.flush();

                                            //System.out.println("Handle Registration CMD Sent");

                                            try{
                                                String RegInfString = registerInfo.get(0)+","+registerInfo.get(1)+","+
                                                        registerInfo.get(2)+","+registerInfo.get(3)+","+
                                                        registerInfo.get(4);

                                                oos.writeObject(RegInfString);
                                                insciptionController = 7;
                                            }

                                            catch(Exception e){
                                                System.out.println("Impossible de joindre le serveur");
                                            }

                                            inscription = false;
                                            connectionTracker = 5;
                                            break;

                                    }
                                }
                                //connected = false;
                                break;

                        // Deconnection
                        case 5:

                            //System.out.println("case 5 reached succesfully");

                            Object objet;

                            if((objet = ois.readObject().toString()) != null){

                                System.out.println(objet);

                            }


                            connected = false;
                            programRunning = false;


                            break;

                    }
                }

                socket.close();
                System.out.println("Socket Closed");

            } catch (Exception e) {

                programRunning = false;
                System.out.println("Connexion impossible au serveur");
                //e.printStackTrace();

            }
        }

        System.out.println("Fin du programme");
        sc.close();

    }
}