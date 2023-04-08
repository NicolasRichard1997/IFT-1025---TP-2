package gui.client_fx;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

/**
 * La classe Model regroupe toutes les methodes qui composent la logique du client. Les classes "MODEL"
 * de client_fx et client_simple sont parfaitement identiques.
 */
public class Model {


    //Methods


    /**
     * La methode formatte un String qui sera envoye au serveur pour charger les cours de facon a ce qu'il soit
     * comprehensible par le serveur.
     * @param arg ici arg est un string de valeure "1", "2", "3" qui represente la session choisie par l'usager
     * @return est un string qui juxtapose la commande "CHARGER" a envoyer au serveur et la session choisie en arg
     */
    public static String loadCoursesCMD(String arg) {
        return "CHARGER" + " " + arg;
    }

    /**
     * La methode ici converti un objet recu par le serveur en un ArrayList 2D de type ArrayList<ArrayList<String>>.
     * La methode est "unchecked" car Java nous previent que l'objet recu n'est peut-etre pas de ce type.
     * @param object Objet recu par le serveur du type le plus generique objet
     * @return retourne un ArrayList 2D de type ArrayList<ArrayList<String>> qui contient les informations sur les
     * cours disponibles a une session particuliere dans le contexte ici.
     */
    @SuppressWarnings("Unchecked")
    public static ArrayList<ArrayList<String>> objectToCourseList(Object object) {
        ArrayList<ArrayList<String>> courses = (ArrayList<ArrayList<String>>) object;
        return courses;
    }

    /**
     * Premiere Verification du prenom de l'etudiant. Le nom doit posseder une lettre majuscule pour commencer, suivi de
     * 1 ou plus de caracteres minuscules (a-z) ou majsucules (A-Z) avec des caracteres acceptables supplementaires
     * ( .'-) (ie:di Caprio","O'Connell) . Les characteres accentues (À-ÿ) sont aussi acceptables.
     *
     * @param userFirstName String entre par l'etudiant sur la ligne de commande (String)
     * @return un booleen true si le prenom de l'usager passe la verification, false si non.
     */
    public static boolean checkFirstname(String userFirstName){

        Pattern firstNamePattern = Pattern.compile("[A-Z][a-zA-ZÀ-ÿ .'-]+"); // Commence par une Majuscule

        Matcher matcher = firstNamePattern.matcher(userFirstName);

        boolean match = matcher.find();

        if (match == true){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Verification du nom de l'etudiant. Le nom doit avoir 1 ou plus de caracteres minuscules (a-z) ou majsucules
     * (A-Z) avec des caracteres acceptables supplementaires. Les characteres accentues (À-ÿ) sont aussi acceptables.
     *
     * @param userLastName String entre par l'etudiant sur la ligne de commande (String)
     * @return un booleen true si le nom de l'usager passe la verification, false si non.
     */
    public static boolean checkLastName(String userLastName) {

        Pattern firstNamePattern = Pattern.compile("[a-zA-ZÀ-ÿ .'-]+"); // Permet: "di Caprio","O'Connell"

        Matcher matcher = firstNamePattern.matcher(userLastName);

        boolean match = matcher.find();

        if (match == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verification du email de l'etudiant. Le courriel de l'etudiant doit avoir la structure suivante:
     * xxxx.xxx(.Y)@umontreal.ca ou .Y est un chiffre optionnel et les x des lettres minuscules. Evidemment dans un
     * portail d'enregistrement de l'UdeM, seuls les courriels de l'universite sont autorises.
     *
     * @param userEmail email entre par l'etudiant avec la ligne de commande (String)
     * @return un booleen true si le email de l'usager passe la verification, false si non.
     */
    public static boolean checkEmail(String userEmail){
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

    /**
     * Verification du matricule de l'etudiant. il s'agit d"un matricule a 8 chiffres. Aucune restriction sur l'ordre
     * ou sur les chiffres entres, tel que 00000000 soit aussi acceptable que 12345678.
     *
     * @param userMatricule Matricule entre par l'etudiant lors de la saisie sur la ligne de commande (String)
     * @returnun booleen true si le matricule entre par l'usager passe la verification, false si non.
     */
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

    /**
     * Verification du format du code de cours entre par l'etudiant. LA METHODE ICI EST UTILISE SEULEMENT dans le
     * client simple car AUCUNE verification n'est necessaire dans le GUI. La methode est quand meme presente ici
     * car la methode est element de la logique du client. le code de cours doit posseder exactement 3 majuscules
     * consecutives suivies de 4 chiffres consecutifs, juxtaposes sans espaces.
     *
     * @param courseCode cours de cours entre par l'etudiant (String)
     * @return un booleen true si le code de cours entre par l'usager passe la verification, false si non.
     */
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