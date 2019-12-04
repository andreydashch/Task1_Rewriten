/*
 * @(#) Controller.java
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
import ua.training.task1.model.ammunition.AmmunitionFactory;
import ua.training.task1.model.knight.Knight;
import ua.training.task1.view.View;
import ua.training.task1.view.constant.TextConst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author      Dashchyk Andrey
 */
public class Controller {
    static final AmmunitionFactory ammunitionFactory = AmmunitionFactory.getInstance();
    static final String INPUT_SEPARATOR = ";";
    static final int STRING_INPUT_PARAMETERS = 2;
    private View view;
    private Knight knight;

    public Controller(Knight knight, View view){
        this.view = view;
        this.knight = knight;
    }

    public void processUser(){
        Scanner sc = new Scanner(System.in);
        HashMap<String, Ammunition> knightAmmunition;

        knightAmmunition = createKnightAmmunitionMap();

        knight = new Knight(knightAmmunition);
        printAmmunitionArrayList(knight.sortAmmunitionByPrice());
    }

    private HashMap<String, Ammunition> createKnightAmmunitionMap(String[] ammunitionArray) {
        double[] initialDouble;
        Ammunition ammunition;
        HashMap<String, Ammunition> knightAmmunition = new HashMap<>();


        for(String ammunitionInitial : ammunitionArray) {
            String[] initialString = ammunitionInitial.split(INPUT_SEPARATOR);
            initialDouble = extractDoubleArray(initialString);

            ammunition = ammunitionFactory.produce(initialString[1], initialString[2], initialDouble[0],
                    initialDouble[1], initialDouble[2], initialDouble[3], initialDouble[4], initialDouble[5]);

            knightAmmunition.put(initialString[0], ammunition);
        }

        return knightAmmunition;
    }

    private double[] extractDoubleArray(String[] initialString) {
        double[] initialDouble = new double[initialString.length - STRING_INPUT_PARAMETERS];
        for(int i=STRING_INPUT_PARAMETERS;i <= initialString.length-1;i ++) {
            initialDouble[i - STRING_INPUT_PARAMETERS] = Double.parseDouble(initialString[i]);
        }

        return initialDouble;
    }

    private void printAmmunitionArrayList(ArrayList<Ammunition> ammunitionArray) {
        int index;
        int arrayLength, stringLength;
        String ammunitionString;
        StringBuilder[] lines;

        arrayLength = countStringLines(ammunitionArray.get(0).toString());
        stringLength = ammunitionArray.get(2).toString().length() + 2;
        stringLength *= Knight.getBodyPartsNames().size();

        lines = initialiseStringBuilderString(arrayLength, stringLength);
        formOutputLines(ammunitionArray, lines);

        for (StringBuilder line : lines) {
            view.printlnMessage(line.toString());
        }
    }

    private void formOutputLines(ArrayList<Ammunition> ammunitionArray, StringBuilder[] lines) {
        int index;
        String ammunitionString;
        for(Ammunition ammunition : ammunitionArray) {
            index = 0;
            ammunitionString = ammunition.toString();

            for(String linePart : ammunitionString.split(TextConst.NEW_LINE)) {
                lines[index].append(linePart);
                lines[index].append(TextConst.TEXT_SEPARATOR);
                index ++;
            }
        }
    }

    private StringBuilder[] initialiseStringBuilderString(int arrayLength, int stringLength) {
        StringBuilder[]  stringBuilderArray = new StringBuilder[arrayLength];

        for (StringBuilder stringBuilder : stringBuilderArray) {
            stringBuilder = new StringBuilder(stringLength);
        }

        return  stringBuilderArray;
    }

    private int countStringLines(String string) {
        int lines = 1;
        Matcher m = Pattern.compile(TextConst.NEW_LINE).matcher(string);

        while (m.find())
        {
            lines ++;
        }

        return lines;
    }
}

