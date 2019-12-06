/*
 * @(#) Input.java
 *
 * MIT License
 *
 * Copyright (c) 2019 Dashchyk Andrey
 *
 * Permission is hereby granted, free of charge,to any
 * person obtaining a copy of this software and
 * associated documentation files (the "Software"), to
 * deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify,
 * merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to
 * whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission
 * notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY
 * OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES
 * OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM,  OUT OF
 * OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */


package ua.training.task1.controller;

import ua.training.task1.model.ammunition.Ammunition;
import ua.training.task1.model.knight.Knight;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ResourceBundle;


/**
 * @author      Dashchyk Andrey
 */
public class Input {
    public Input() {
    }

    public Knight createKnight(String fileName) {
        HashMap<String, Ammunition> knightAmmunition;

        String[] ammunitionArray = getAmmunitionFromRecourseBundle(fileName);

        knightAmmunition = createKnightAmmunitionMap(ammunitionArray);

        return new Knight(knightAmmunition);
    }

    public Knight createKnight(String[] ammunitionArray) {
        HashMap<String, Ammunition> knightAmmunition;

        knightAmmunition = createKnightAmmunitionMap(ammunitionArray);

        return new Knight(knightAmmunition);
    }

    public HashMap<String, Ammunition> createKnightAmmunitionMap(String[] ammunitionArray) {
        double[] initialDouble;
        Ammunition ammunition;
        HashMap<String, Ammunition> knightAmmunition = new HashMap<>();


        for (String ammunitionInitial : ammunitionArray) {
            String[] initialString = ammunitionInitial.split(Const.INPUT_SEPARATOR);
            initialDouble = extractDoubleArray(initialString);

            ammunition = Const.ammunitionFactory.produce(initialString[1], initialString[2], initialDouble[0],
                    initialDouble[1], initialDouble[2], initialDouble[3], initialDouble[4]);

            knightAmmunition.put(initialString[0], ammunition);
        }

        return knightAmmunition;
    }

    private String[] getAmmunitionFromRecourseBundle(String fileName) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(fileName);
        HashSet<String> keySet = new HashSet<>(resourceBundle.keySet());
        int index = 0;

        String[] ammunitionArray = new String[keySet.size()];

        for(String key : keySet.toArray(ammunitionArray)) {
            ammunitionArray[index] = resourceBundle.getString(key);
            index ++;
        }

        return ammunitionArray;
    }

    private double[] extractDoubleArray(String[] initialString) {
        double[] initialDouble = new double[initialString.length - Const.STRING_INPUT_PARAMETERS];
        for (int i = Const.STRING_INPUT_PARAMETERS; i <= initialString.length - 1; i++) {
            initialDouble[i - Const.STRING_INPUT_PARAMETERS] = Double.parseDouble(initialString[i]);
        }

        return initialDouble;
    }
}