package ext;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component("dao")
public class DaoImpl2 implements IDao {
    @Override
    public double getData() {
        System.out.println("Version capteurs");
        double temp = 6000;
        return temp;
    }
}
