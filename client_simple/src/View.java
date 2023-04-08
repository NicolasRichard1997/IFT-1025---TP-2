import java.util.ArrayList;
import java.util.List;

public class View {


    // Variables
    public static String welcomeText = "*** Bienvenue au portail d'inscription de cours de l'UdeM ***";

    public static String sessionSelection = "Veuillez choisir la session pour laquelle vous voulez consulter " +
            "la liste des cours:\n1. Automne\n2. Hiver\n3. Ete";

    public static List<String> sessions = new ArrayList<>(List.of("1", "2", "3"));




    //Methods

    public static void commandLineprint(String text){
        System.out.println(text);
    }

    public static void promptUserChoice() {
        System.out.println("\n> Choix: ");
    }
    public static void selectionError() {
        System.out.println("*** Veuillez entrer le chiffre correspondant a votre selection ***");
    }
    public static void userInputValidationFail() {
        System.out.println("\n*** Valeure invalide. SVP reessayer ***");
    }

    public static void welcomeRegisterMenu() {
        System.out.println("\n*** Menu d'inscription ****");
    }
    public static void promptUserFisrtName() {
        System.out.println("Veuillez saisir votre prenom: ");
    }
    public static void promptUserLastName() {
        System.out.println("\nVeuillez saisir votre nom: ");
    }
    public static void promptUserEmail() {
        System.out.println("\nVeuillez saisir votre email: ");
    }
    public static void promptUserMatricule() {
        System.out.println("\nVeuillez saisir votre matricule: ");
    }
    public static void promptUserCourseCode() {
        System.out.println("\nVeuillez saisir le code du cours: ");
    }



    public static void displayCourseList (ArrayList<ArrayList<String>> courselist) {
        System.out.println("\nCours offerts pour cette session:");
        for (int i = 0; i < courselist.get(0).size(); i++) {
            System.out.println(i + 1 + ".\t" + courselist.get(0).get(i) + "\t" + courselist.get(1).get(i));
        }
    }
    public static void courseListDisplayOptions() {
        System.out.println("\nVeuillez choisir une option:\n1. Consulter les cours offerts pour une autre sessions\n"+
                            "2. Inscription a un cours");
    }
}

