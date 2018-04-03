package test;

import main.Diamond;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiamondTest {

    Diamond diamond;

    @Before
    public void diamondObjectInitializedSuccessfully() {
        diamond = new Diamond();
    }

    @Test
    public void returnsNullIfInputIsTwo() {
        Assert.assertNull(diamond.print(2));
    }

    @Test
    public void returnsNullIfInputIsFour() {
        Assert.assertNull(diamond.print(4));
    }

    @Test
    public void returnsNullIfInputIsSix() {
        Assert.assertNull(diamond.print(6));
    }

    @Test
    public void returnsNullIfInputIsANegativeNumber() {
        Assert.assertNull(diamond.print(-7));
    }

    @Test
    public void givenInput1GetOneStarDiamond() {
        StringBuffer expected = new StringBuffer();
        expected.append("*\n");

        assertEquals(expected.toString(), diamond.print(1));
    }

    @Test
    public void givenInput3GetFiveStarDiamond() {
        StringBuffer expected = new StringBuffer();
        expected.append(" *\n");
        expected.append("***\n");
        expected.append(" *\n");

        assertEquals(expected.toString(), diamond.print(3));
    }

    @Test
    public void givenInput5Get13StarDiamond() {
        StringBuffer expected = new StringBuffer();
        expected.append("  *\n");
        expected.append(" ***\n");
        expected.append("*****\n");
        expected.append(" ***\n");
        expected.append("  *\n");

        assertEquals(expected.toString(), diamond.print(5));
    }
}
