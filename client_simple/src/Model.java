import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {


    //Variables
    public static String welcomeText = "*** Bienvenue au portail d'inscription de cours de l'UdeM ***\n" +
            "Veuillez choisir la session pour laquelle vous voulez consulter la liste des cours:\n"
            + "1. Automne\n2. Hiver\n3. Ete\n\n";

    public static List<String> sessions = new ArrayList<>(List.of("1", "2", "3"));

    //Methods
    public static String eventsHandler(String cmd, String arg) {
        return cmd + " " + arg;

    }

    @SuppressWarnings("Unchecked")
    public static ArrayList<ArrayList<String>> objectToCourseList(Object object) {
                    ArrayList<ArrayList<String>> courses = (ArrayList<ArrayList<String>>) object;
                    return courses;
    }

    }

