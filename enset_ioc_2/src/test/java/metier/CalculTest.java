package metier;

import org.junit.Assert;
import org.junit.Test;

public class CalculTest {
    private Calcul calcul;
    @Test
    public void testSomme(){
        calcul = new Calcul();
        double a = 5;
        double b = 6;
        double expected = 11;
        double result = calcul.somme(a,b);
        Assert.assertTrue(result == expected);
    }
}
