public class Test {

    public static void main(String[] args) {
        Chien c = new Chien("Marron foncé", 12);
        c.boire();
        c.manger();
        c.deplacement();
        c.crier();
        System.out.println(c.toString());
    }
}