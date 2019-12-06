package ua.training.task1.knight;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.training.task1.controller.Input;
import ua.training.task1.model.ammunition.Ammunition;
import ua.training.task1.model.knight.Knight;

import java.util.ArrayList;

public class KnightTest {
    static final String[] EMPTY_ARRAY = new String[0];
    static Input input;
    Knight knight;

    @BeforeClass
    public static  void initialisation() {
        input = new Input();
    }

    @Test
    public void findAmmunitionInPriceRangeTestEmptyArray() {
        ArrayList<Ammunition> output;

        knight = input.createKnight(EMPTY_ARRAY);
        output = knight.findAmmunitionInPriceRange(20, 40);

        Assert.assertEquals(0, output.size());
    }

    @Test
    public void findAmmunitionInPriceRangeTest() {
        ArrayList<Ammunition> output = new ArrayList<>();
        ArrayList<Ammunition> expected = new ArrayList<>();

        knight = input.createKnight(EMPTY_ARRAY);
        output = knight.findAmmunitionInPriceRange(20, 40);

        Assert.assertTrue(output.size() == 0);
//        for(int i=0;i <= output.size();i ++) {
//        Assert.assertEquals(expected.get(i), output.get(i));
    }

}
