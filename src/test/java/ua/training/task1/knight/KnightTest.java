package ua.training.task1.knight;

import org.junit.Assert;
import org.junit.Test;
import ua.training.task1.controller.Input;
import ua.training.task1.model.ammunition.WarObject;
import ua.training.task1.model.knight.Knight;

import java.util.ArrayList;
import java.util.List;

public class KnightTest {
    static final Input input = new Input();
    static final String[] EMPTY_ARRAY = new String[0];
    static final String[] ONE_STRING_ARRAY = {"HEAD;armor;Helmet;4;110.20;15;7;8"};
    static final String[] STRING_ARRAY = {
            "HEAD;armor;Helmet;4;110.20;15;7;8",
            "CHEST;armor;Cuirass;20;450;20;20;20",
            "LEFT_HAND;weapon;Sword;5;300;24;7;16",
            "LEGS;armor;Leggings;10;150;14;11;8"
    };

    @Test
    public void sortAmmunitionByPriceTestEmptyArray() {
        List<WarObject> output;

        output =  input.createKnight(EMPTY_ARRAY).sortAmmunitionByPrice();

        Assert.assertEquals(0, output.size());
    }

    @Test
    public void sortAmmunitionByPriceTestOneStringArray() {
        List<WarObject> expected = new ArrayList<>(input.createKnightAmmunitionMap(ONE_STRING_ARRAY).values());
        List<WarObject> output;

        Knight knight =  input.createKnight(ONE_STRING_ARRAY);
        output = knight.sortAmmunitionByPrice();

        checkOutput(expected, output);
    }

    @Test
    public void findAmmunitionInPriceRangeTestEmptyArray() {
        List<WarObject> output;

        output =  input.createKnight(EMPTY_ARRAY).findAmmunitionInPriceRange(20, 40);
        Assert.assertEquals(0, output.size());
    }

    @Test
    public void findAmmunitionInPriceRangeTestOneStringArrayTrue() {
        List<WarObject> expected = new ArrayList<>(input.createKnightAmmunitionMap(ONE_STRING_ARRAY).values());
        List<WarObject> output;

        output =  input.createKnight(ONE_STRING_ARRAY).findAmmunitionInPriceRange(0, 400);

        checkOutput(expected, output);
    }

    @Test
    public void findAmmunitionInPriceRangeTestOneStringArrayIncorrectBorders() {
        List<WarObject> expected = new ArrayList<>();
        List<WarObject> output;

        output =  input.createKnight(ONE_STRING_ARRAY).findAmmunitionInPriceRange(400, 0);

        checkOutput(expected, output);
    }

    @Test
    public void findAmmunitionInPriceRangeTestOneStringArrayFalse() {
        List<WarObject> expected = new ArrayList<>();
        List<WarObject> output;

        output =  input.createKnight(ONE_STRING_ARRAY).findAmmunitionInPriceRange(0, 20);

        checkOutput(expected, output);
    }

    @Test
    public void findAmmunitionInPriceRangeTestStringArrayTrue() {
        List<WarObject> expected = new ArrayList<>(input.createKnightAmmunitionMap(STRING_ARRAY).values());
        List<WarObject> output;

        output =  input.createKnight(STRING_ARRAY).findAmmunitionInPriceRange(0, 1000);

        checkOutput(expected, output);
    }

    @Test
    public void findAmmunitionInPriceRangeTestStringArrayFalse() {
        List<WarObject> expected = new ArrayList<>();
        List<WarObject> output;

        output =  input.createKnight(STRING_ARRAY).findAmmunitionInPriceRange(1000, 1100);

        checkOutput(expected, output);
    }

    @Test
    public void findAmmunitionInPriceRangeTestStringArrayOneTrue() {
        List<WarObject> expected = new ArrayList<>(input.createKnightAmmunitionMap(ONE_STRING_ARRAY).values());
        List<WarObject> output;

        output =  input.createKnight(STRING_ARRAY).findAmmunitionInPriceRange(110, 115);

        checkOutput(expected, output);
    }

    private void checkOutput(List<WarObject> expected, List<WarObject> output) {
        for (int i = 0; i <= output.size() - 1; i++) {
            Assert.assertEquals(expected.get(i), output.get(i));
        }

       Assert.assertEquals(expected.size(), output.size());
    }

}
