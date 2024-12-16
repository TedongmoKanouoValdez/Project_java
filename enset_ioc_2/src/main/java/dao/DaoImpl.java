package dao;

public class DaoImpl implements IDao{
    @Override
    public double getData() {
        /*
        se connecter à la BD pour recuperer la temperature

         */
        System.out.println("version base de données");
        double temp = Math.random()*40;
        return temp;
    }
}
