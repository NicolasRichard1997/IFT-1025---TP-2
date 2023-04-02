public class Model {


    //Variables
    public static String welcomeText = "*** Bienvenue au portail d'inscription de cours de l'UdeM ***\n" +
            "Veuillez choisir la session pour laquelle vous voulez consulter la liste des cours:\n"
            +"1. Automne\n2. Hiver\n3. Ete\n\n"+"> Choix: ";


    //Methods
    public static String eventsHandler(String cmd, String arg){
        return cmd+" "+arg;


    }

}
