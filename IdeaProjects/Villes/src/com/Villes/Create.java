public class Create {

    public static void main(String[] args) {
        Ville v = null;
        try {
            v = new Ville("Rennes", 12000, "France");
        }
        catch (NombreHabitantException e) {}

        System.out.println(v.toString());

        /* Capitale Paris = new Capitale("Paris", 1000, "France");
        Paris.print_name();

        Capitale Paris2 = new Capitale("Paris", 1000, "France");
        Paris2.print_name(); */
    }
}