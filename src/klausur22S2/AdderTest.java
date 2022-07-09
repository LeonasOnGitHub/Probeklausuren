package klausur22S2;

import org.junit.Assert;
import org.junit.Test;

public class AdderTest {
    Adder add = new AdderImpl();

    @Test
    public void gutTest1() throws adderException {
        add.backdor(0);
        int num1 = 10;
        int num2 = 11;
        int dummyInt = 21;
        add.add(num1, num2);

        Assert.assertEquals(dummyInt, add.getResult());
    }

    @Test
    public void gutTest2() throws adderException {
        add.backdor(0);

        int num = 1;
        int dummyInt = 22;
        add.add(num);

        Assert.assertEquals(dummyInt, add.getResult());
    }

    @Test
    public void randTest1() throws adderException {
        add.backdor(0);
        int num1 = Integer.MAX_VALUE - 1;
        int num2 = 1;
        int dummyInt = Integer.MAX_VALUE;
        add.add(num1, num2);

        Assert.assertEquals(dummyInt, add.getResult());
    }

    @Test
    public void randTest2() throws adderException {
        add.backdor(0);

        int num = 1;
        int dummyInt = Integer.MAX_VALUE - 99;
        add.add(num);

        Assert.assertEquals(dummyInt, add.getResult());
    }

    @Test(expected = adderException.class)
    public void schlechtTest1() throws adderException {
        add.backdor(0);
        int num1 = Integer.MAX_VALUE;
        int num2 = 1;

        add.add(num1, num2);
    }

    @Test(expected = adderException.class)
    public void schlechtTest2() throws adderException {
        add.backdor(1);
        int num1 = Integer.MAX_VALUE;

        add.add(num1);
    }

    @Test(expected = adderException.class)
    public void schlechtTest3() throws adderException {
        add.backdor(0);
        int num1 = -1;

        add.add(num1);
    }

    @Test(expected = adderException.class)
    public void schlechtTest4() throws adderException {
        add.backdor(0);
        int num1 = -1;
        int num2 = 1;

        add.add(num1, num2);
    }

}
