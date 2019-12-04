package ua.training.task1.controller;

import ua.training.task1.model.ammunition.Ammunition;

import java.util.HashMap;

public class input {
    public input() {
    }

    HashMap<String, Ammunition> createKnightAmmunitionMap(String[] ammunitionArray) {
        double[] initialDouble;
        Ammunition ammunition;
        HashMap<String, Ammunition> knightAmmunition = new HashMap<>();


        for (String ammunitionInitial : ammunitionArray) {
            String[] initialString = ammunitionInitial.split(Controller.INPUT_SEPARATOR);
            initialDouble = extractDoubleArray(initialString);

            ammunition = Controller.ammunitionFactory.produce(initialString[1], initialString[2], initialDouble[0],
                    initialDouble[1], initialDouble[2], initialDouble[3], initialDouble[4], initialDouble[5]);

            knightAmmunition.put(initialString[0], ammunition);
        }

        return knightAmmunition;
    }

    double[] extractDoubleArray(String[] initialString) {
        double[] initialDouble = new double[initialString.length - Controller.STRING_INPUT_PARAMETERS];
        for (int i = Controller.STRING_INPUT_PARAMETERS; i <= initialString.length - 1; i++) {
            initialDouble[i - Controller.STRING_INPUT_PARAMETERS] = Double.parseDouble(initialString[i]);
        }

        return initialDouble;
    }
}