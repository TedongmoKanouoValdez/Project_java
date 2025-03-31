package metier;

import dao.IDao;

public class MetierImpl implements IMetier {

    private IDao dao; // couplage faible

    @Override
    public double calcul() {
        double tmp = dao.getData();
        double result = tmp*548/Math.cos(tmp*Math.PI);
        return result;
    }
    /*
        Injecter dans la variable dao un objet d'une classe
        qui implemente l'interface IDao
     */

   public void setDao(IDao dao) {
        this.dao = dao;
   }
   /* public void setData(IDao dao) {
        this.dao = dao;
    }*/
}
