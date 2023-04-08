package gui.client_fx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;


/**
 * La classe Controller coordonne le Model (constant entre les deux clients) et les deux View differentes.
 */
public class Controller {


    /**
     * La methode ici coordonne entre le serveur et client GUI le chargement des cours dans l'interface GUI presente
     * dans view. Le parametre session represente un String de texte qui lui represente la session a charge a partir
     * du MenuButton approprie. La methode retourne un ArrayList<ArrayList<String>> 2D qui contient les informations
     * a charger sur l'element TableView qui affichera les cours disponible spour une session choisie.
     *
     * @param session "Automne","Hiver","Ete" selon le choix de l'usager. "" si lusager n'a pas fait de choix.
     * @return ArrayList<ArrayList<String>> 2D qui contient les codes et noms des cours disponible pour la session
     * choisie plus haut.
     */
    public static ArrayList<ArrayList<String>> loadSession(String session){

        ArrayList<ArrayList<String>> courselist = null;

        String arg ="";

        switch(session){
            case "Automne":
                arg = "1";
                break;

            case "Hiver":
                arg = "2";
                break;

            case "Ete":
                arg = "3";
                break;
        }

        try {
            String localHostIP = "127.0.0.1";
            int    port        =  1337;

            // Initialize Socket
            Socket socket = new Socket(localHostIP, port);
            //System.out.println("Socket Open");

            //Object Input/Output Initialized
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());


            oos.writeObject(Model.loadCoursesCMD(arg));
            oos.flush();

            courselist = Model.objectToCourseList(ois.readObject());

            socket.close();
        }
        catch (Exception e){
            System.out.println("Impossible de recevoir de l'information du serveur le serveur");
        }
        return courselist;
    }
}





