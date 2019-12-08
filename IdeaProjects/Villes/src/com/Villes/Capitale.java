class Capitale extends Ville {

    //public static void main(String[] args) {
    //    Capitale cap = new Capitale();
    //    System.out.println(cap.decrisToi());
    //}

    public Capitale(String pNom, int pNbre, String pPays){
        super(pNom, pNbre, pPays);
    }

    public void print_name(){
        System.out.println(this.nomVille);
    }
}