class NombreHabitantException extends Exception {
    public NombreHabitantException() {
        System.out.println("Vous essayez d'instancer une classe Ville avec un nombre d'habitants négatif !");
    }
}