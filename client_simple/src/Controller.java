import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {

        // Socket
        String localHostIP = "127.0.0.1";
        int    port        =  1337;

        // Opens the Scanner
        Scanner sc  = new Scanner(System.in);

        try {
            Socket socket = new Socket(localHostIP,port);
            //System.out.println("Connexion au port 1337");


            //Object Input/Output Initialized
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream  ois = new ObjectInputStream(socket.getInputStream());



            //
            boolean connected = true;


            //Initialise la variable ConnectionTracker qui agit comme "variable-controlleur" du programme
            int ConnectionTracker = 0;


            //Maintient de la connection
            while (connected) {



                switch (ConnectionTracker) {

                    // Ecran de Bienvenue
                    case 0:

                        View.welcomeMessage();
                        ConnectionTracker ++;
                        break;

                    //Menu de Chargement
                    case 1:
                        View.promptUserChoice();
                        //Scanner In
                        String arg = sc.next();
                        sc.nextLine();

                        //
                        if (Model.sessions.contains(arg) == true){
                            //System.out.println(Model.sessions.contains(arg));
                            oos.writeObject(Model.eventsHandler("CHARGER", arg));
                            ConnectionTracker ++;

                        }
                        else{
                            View.sessionSelectionError();
                        }
                        break;

                    // Page de Selection de cours
                    case 2:
                        System.out.println("case 2");

                        try{

                            ArrayList<ArrayList<String>> courselist = Model.objectToCourseList(ois.readObject());

                            System.out.print(courselist);

                        }
                        catch(IOException | ClassNotFoundException e){
                            System.out.println("Not working");
                            connected = false;
                        }


                        break;


                    // Page d'Inscription
                    case 3:
                        // code block


                        // Deconnexion
                    default:
                        connected = false;
                }
            }
            System.out.println("Closing socket and terminating program.");
            socket.close();

        } catch (ConnectException x) {
            System.out.println("Connexion impossible au port 1337: pas de serveur.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}