package ua.training.task1.knight;

import org.junit.Assert;
import org.junit.Test;
import ua.training.task1.controller.Input;
import ua.training.task1.model.ammunition.Ammunition;

import java.util.ArrayList;

public class KnightTest {
    static final String[] EMPTY_ARRAY = new String[0];
    static final String[] ONE_STRING_ARRAY = {"head;armor;Helmet;4;110.20;15;7;8"};
    static final String[] STRING_ARRAY = {
            "head;armor;Helmet;4;110.20;15;7;8",
            "chest;armor;Cuirass;20;450;20;20;20",
            "leftHand;weapon;Sword;5;300;24;7;16",
            "legs;armor;Leggings;10;150;14;11;8"
    };
    static Input input = new Input();

    @Test
    public void sortAmmunitionByPriceTestEmptyArray() {
        ArrayList<Ammunition> output;

        output = input.createKnight(EMPTY_ARRAY).sortAmmunitionByPrice();

        Assert.assertEquals(0, output.size());
    }

    @Test
    public void findAmmunitionInPriceRangeTestEmptyArray() {
        ArrayList<Ammunition> output;

        output = input.createKnight(EMPTY_ARRAY).findAmmunitionInPriceRange(20, 40);

        Assert.assertEquals(0, output.size());
    }

    @Test
    public void findAmmunitionInPriceRangeTestOneStringArrayTrue() {
        ArrayList<Ammunition> expected = new ArrayList<>(input.createKnightAmmunitionMap(ONE_STRING_ARRAY).values());
        ArrayList<Ammunition> output;

        output = input.createKnight(ONE_STRING_ARRAY).findAmmunitionInPriceRange(0, 400);

        checkOutput(expected, output);
    }

    @Test
    public void findAmmunitionInPriceRangeTestOneStringArrayIncorrectBorders() {
        ArrayList<Ammunition> expected = new ArrayList<>();
        ArrayList<Ammunition> output;

        output = input.createKnight(ONE_STRING_ARRAY).findAmmunitionInPriceRange(400, 0);

        checkOutput(expected, output);
    }

    @Test
    public void findAmmunitionInPriceRangeTestOneStringArrayFalse() {
        ArrayList<Ammunition> expected = new ArrayList<>();
        ArrayList<Ammunition> output;

        output = input.createKnight(ONE_STRING_ARRAY).findAmmunitionInPriceRange(0, 20);

        checkOutput(expected, output);
    }

    @Test
    public void findAmmunitionInPriceRangeTestStringArrayTrue() {
        ArrayList<Ammunition> expected = new ArrayList<>(input.createKnightAmmunitionMap(STRING_ARRAY).values());
        ArrayList<Ammunition> output;

        output = input.createKnight(STRING_ARRAY).findAmmunitionInPriceRange(0, 1000);

        checkOutput(expected, output);
    }

    @Test
    public void findAmmunitionInPriceRangeTestStringArrayFalse() {
        ArrayList<Ammunition> expected = new ArrayList<>();
        ArrayList<Ammunition> output;

        output = input.createKnight(STRING_ARRAY).findAmmunitionInPriceRange(1000, 1100);

        checkOutput(expected, output);
    }

    @Test
    public void findAmmunitionInPriceRangeTestStringArrayOneTrue() {
        ArrayList<Ammunition> expected = new ArrayList<>(input.createKnightAmmunitionMap(ONE_STRING_ARRAY).values());
        ArrayList<Ammunition> output;

        output = input.createKnight(STRING_ARRAY).findAmmunitionInPriceRange(110, 115);

        checkOutput(expected, output);
    }

    private void checkOutput(ArrayList<Ammunition> expected, ArrayList<Ammunition> output) {
        for (int i = 0; i <= output.size() - 1; i++) {
            Assert.assertEquals(expected.get(i), output.get(i));
        }

        Assert.assertEquals(expected.size(), output.size());
    }

}
