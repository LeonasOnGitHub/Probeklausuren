package Klausur21S1;

import org.junit.Assert;
import org.junit.Test;

public class AutomatTest {
    Automat a = new AutomatImpl();

    @Test
    public void gutTest1() throws UknownWordExeption {
        a.readSign('A');
        a.readSign('A');
        Assert.assertTrue(a.readable());
        a.readSign('C');

        Assert.assertEquals("AAC", a.getZeichenkette());
    }

    @Test
    public void gutTest2() throws UknownWordExeption {
        a.readSign('A');
        Assert.assertTrue(a.readable());
        a.readSign('A');
        a.readSign('C');
        Assert.assertFalse(a.readable());
        a.readSign('C');

        Assert.assertEquals("AAC", a.getZeichenkette());
    }

    @Test
    public void gutTest3() throws UknownWordExeption {
        a.readSign('B');
        a.readSign('D');
        Assert.assertFalse(a.readable());

        Assert.assertEquals("BD", a.getZeichenkette());
    }

    @Test
    public void gutTest4() throws UknownWordExeption {
        a.readSign('B');
        a.readSign('D');
        a.readSign('B');
        a.readSign('C');

        Assert.assertEquals("BD", a.getZeichenkette());
    }

    @Test
    public void gutTest5() throws UknownWordExeption {
        a.readSign('B');
        a.readSign('D');
        a.readSign('D');
        a.readSign('D');

        Assert.assertEquals("BD", a.getZeichenkette());
    }

    @Test(expected = UknownWordExeption.class)
    public void badTest1() throws UknownWordExeption {
        a.readSign('B');
        a.getZeichenkette();
    }
    @Test(expected = UknownWordExeption.class)
    public void badTest2() throws UknownWordExeption {
        a.readSign('B');
        a.readSign('C');

    }@Test(expected = UknownWordExeption.class)
    public void badTest3() throws UknownWordExeption {
        a.readSign('B');
        a.readSign('B');
        a.readSign('B');
        a.readSign('C');

    }
}
