package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("src/config.txt"));

        String daoClassName = sc.nextLine();
        // il recherche le nom de classe il verifie s'il existe en memoire
        // et le charge et s'il n'existe pas il genere une exception
        Class cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.newInstance();
        System.out.println(dao.getData());

        String metierClassName = sc.nextLine();
        Class cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.newInstance();

        Method method = cMetier.getMethod("setDao", IDao.class);
        // metier.setDao(dao);
        method.invoke(metier, dao);

        System.out.println("resultat =>" +metier.calcul());
    }
}
