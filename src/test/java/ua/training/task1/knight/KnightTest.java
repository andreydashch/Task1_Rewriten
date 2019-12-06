package ua.training.task1.knight;

import org.junit.Assert;
import org.junit.Test;
import ua.training.task1.controller.Input;
import ua.training.task1.model.ammunition.Ammunition;
import ua.training.task1.model.ammunition.AmmunitionFactory;
import ua.training.task1.model.knight.Knight;

import java.util.ArrayList;

public class KnightTest {
    static final String[] EMPTY_ARRAY = new String[0];
    static final String[] ONE_STRING_ARRAY = {"head;armor;Helmet;4;110.20;15;7;8"};
    static final AmmunitionFactory factory = AmmunitionFactory.getInstance();
    static Input input = new Input();
    Knight knight;

    @Test
    public void findAmmunitionInPriceRangeTestEmptyArray() {
        ArrayList<Ammunition> output;

        knight = input.createKnight(EMPTY_ARRAY);
        output = knight.findAmmunitionInPriceRange(20, 40);

        Assert.assertEquals(0, output.size());
    }

    @Test
    public void findAmmunitionInPriceRangeTestOneStringArrayTrue() {
        ArrayList<Ammunition> expected = new ArrayList<>(input.createKnightAmmunitionMap(ONE_STRING_ARRAY).values());
        ArrayList<Ammunition> output;

        knight = input.createKnight(ONE_STRING_ARRAY);
        output = knight.findAmmunitionInPriceRange(0, 400);


        for(int i=0;i <= output.size() - 1;i ++) {
            Assert.assertEquals(expected.get(i), output.get(i));
        }
    }

}
