public class View {




    //Methods

    public static void welcomeMessage(){
        System.out.println(Model.welcomeText);
    }

    public static void promptUserChoice() {
        System.out.println("> Choix: ");
    }
    public static void sessionSelectionError() {
        System.out.println("\n*** Attention,Veuillez entrer le chiffre correspondant a " +
                "la session choisie ***\n");
    }
}

