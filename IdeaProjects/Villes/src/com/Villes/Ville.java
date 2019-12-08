public class Ville{
    //Stocke le nom de notre ville
    protected String nomVille;
    //Stocke le nom du pays de notre ville
    protected String nomPays;
    //Stocke le nombre d'habitants de notre ville
    protected int nbreHabitant;

    //Constructeur par défaut
    public Ville(String pNom, int pNbre, String pPays){
       throws NombreHabitantException {
            if(pNbre < 0)
                throw new NombreHabitantException();
            else {
                nbreInstance++;
                nbreInstanceBis++;

                nomVille = pNom;
                nomPays = pPays;
                nbreHabitant = pNbre;
                this.setCategorie();
            }
        }
    }
}

