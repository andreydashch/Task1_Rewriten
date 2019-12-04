/*
 * @(#) Output.java
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
import ua.training.task1.view.constant.TextConst;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author      Dashchyk Andrey
 */
public class Output {
    private final Controller controller;

    public Output(Controller controller) {
        this.controller = controller;
    }

    void printAmmunitionArrayList(ArrayList<Ammunition> ammunitionArray) {
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
            controller.getView().printlnMessage(line.toString());
        }
    }

    private void formOutputLines(ArrayList<Ammunition> ammunitionArray, StringBuilder[] lines) {
        int index;
        String ammunitionString;
        for (Ammunition ammunition : ammunitionArray) {
            index = 0;
            ammunitionString = ammunition.toString();

            for (String linePart : ammunitionString.split(TextConst.NEW_LINE)) {
                lines[index].append(linePart);
                lines[index].append(TextConst.TEXT_SEPARATOR);
                index++;
            }
        }
    }

    private StringBuilder[] initialiseStringBuilderString(int arrayLength, int stringLength) {
        StringBuilder[] stringBuilderArray = new StringBuilder[arrayLength];

        for (StringBuilder stringBuilder : stringBuilderArray) {
            stringBuilder = new StringBuilder(stringLength);
        }

        return stringBuilderArray;
    }

    private int countStringLines(String string) {
        int lines = 1;
        Matcher m = Pattern.compile(TextConst.NEW_LINE).matcher(string);

        while (m.find()) {
            lines++;
        }

        return lines;
    }
}