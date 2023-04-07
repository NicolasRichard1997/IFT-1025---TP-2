package gui.client_fx;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class Model {


    //Variables
    public static String welcomeText = "*** Bienvenue au portail d'inscription de cours de l'UdeM ***";

    public static String sessionSelection = "Veuillez choisir la session pour laquelle vous voulez consulter " +
            "la liste des cours:\n1. Automne\n2. Hiver\n3. Ete";

    public static List<String> sessions = new ArrayList<>(List.of("1", "2", "3"));

    //Methods
    public static String loadCoursesCMD(String arg) {
        return "CHARGER" + " " + arg;
    }

    public static String registerCMD() {
        return "INSCRIRE" + " " + "NotAString";
    }

    @SuppressWarnings("Unchecked")
    public static ArrayList<ArrayList<String>> objectToCourseList(Object object) {
        ArrayList<ArrayList<String>> courses = (ArrayList<ArrayList<String>>) object;
        return courses;
    }

    public static boolean checkFirstname(String userFirstName){

        Pattern firstNamePattern = Pattern.compile("[A-Z]{1}[a-zA-Z ,.'-]*"); // Commence par une Majuscule

        Matcher matcher = firstNamePattern.matcher(userFirstName);

        boolean match = matcher.find();

        if (match == true){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean checkLastName(String userLastName) {

        Pattern firstNamePattern = Pattern.compile("[a-zA-Z]+[a-zA-Z ,.'-]*"); // Permet: "di Caprio","O'Connell"

        Matcher matcher = firstNamePattern.matcher(userLastName);

        boolean match = matcher.find();

        if (match == true) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean checkEmail(String userEmail){


        // Structure: xxxx.xxx(.Y)@umontreal.ca ou .Y est un chiffre optionnel et les x des lettres minuscules
        Pattern emailPattern = Pattern.compile("[a-z]+[.][a-z]+[.]?[0-9]?@umontreal[.]ca");

        Matcher matcher = emailPattern.matcher(userEmail);

        boolean match = matcher.find();

        if (match == true){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean checkMatricule(String userMatricule){

        Pattern emailPattern = Pattern.compile("[0-9]{8}");

        Matcher matcher = emailPattern.matcher(userMatricule);

        boolean match = matcher.find();

        if (match == true){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean checkCourseCode(String courseCode){

        Pattern emailPattern = Pattern.compile("[A-Z]{3}[0-9]{4}");

        Matcher matcher = emailPattern.matcher(courseCode);

        boolean match = matcher.find();

        if (match == true){
            return true;
        }
        else{
            return false;
        }
    }
}