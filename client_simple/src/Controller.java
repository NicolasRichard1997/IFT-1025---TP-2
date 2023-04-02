import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {

        // Socket
        String localHostIP = "127.0.0.1";
        int    port        =  1337;



        try {
            Socket socket = new Socket(localHostIP,port);
            System.out.println("Connexion au port 1337");


            //
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());



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

                        Scanner sc  = new Scanner(System.in);
                        int arg = sc.nextInt();
                        sc.close();

                        oos.writeObject(Model.eventsHandler("CHARGER", Integer.toString(arg)));

                        ConnectionTracker++;
                        connected = false;

                        break;

                    // Page de Selection de cours
                    case 1:
                        // code block
                        break;


                    // Page d'Inscription
                    case 2:
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
    }
}