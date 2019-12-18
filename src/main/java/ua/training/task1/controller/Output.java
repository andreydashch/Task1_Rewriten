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
import ua.training.task1.model.ammunition.WarObject;
import ua.training.task1.model.knight.Knight;
import ua.training.task1.view.TextOutput;

import java.util.ArrayList;

/**
 * @author      Dashchyk Andrey
 */
public class Output {
    private final Controller controller;

    public Output(Controller controller) {
        this.controller = controller;
    }

    /**
     * Show ammunitionArray to user with View
     *
     * @param ammunitionArray array to show
     * @param coverMessage message upper the array
     */
    public void printAmmunitionArrayList(ArrayList<WarObject> ammunitionArray, String coverMessage) {
        int arrayLength, stringLength;
        int fullTableWidth;
        StringBuilder[] lines;

        arrayLength = Ammunition.class.getDeclaredFields().length + 1;
        stringLength = TextOutput.OUTPUT_TABLE_WIDTH;
        stringLength *= Knight.getBodyPartsNames().size();

        lines = initialiseStringBuilder(arrayLength, stringLength);
        formOutputLines(ammunitionArray, lines);

        fullTableWidth =
                (TextOutput.OUTPUT_TABLE_WIDTH + TextOutput.TABLE_SEPARATOR.length()) *
                        ammunitionArray.size() + TextOutput.NEW_LINE.length();

        controller.getView().printlnMessage(formatTitleLine(coverMessage, fullTableWidth));

        for (StringBuilder line : lines) {
            controller.getView().printlnMessage(line.toString());
        }

        controller.getView().printlnMessage(TextOutput.EMPTY);
    }

    private void formOutputLines(ArrayList<WarObject> ammunitionArray, StringBuilder[] lines) {
        int index;
        String ammunitionString;

        for (WarObject warObject : ammunitionArray) {
            index = 0;
            ammunitionString = makeAmmunitionString(warObject);

            for (String linePart : ammunitionString.split(TextOutput.NEW_LINE)) {
                lines[index].append(linePart);
                lines[index].append(TextOutput.TABLE_SEPARATOR);
                index ++;
            }
        }
    }

    private StringBuilder[] initialiseStringBuilder(int arrayLength, int stringLength) {
        StringBuilder[] stringBuilderArray = new StringBuilder[arrayLength];

        for (int i=0;i <= stringBuilderArray.length - 1;i ++) {
            stringBuilderArray[i] = new StringBuilder(stringLength);
        }

        return stringBuilderArray;
    }

    private String makeAmmunitionString(WarObject warObject) {
        return  formatTitleLine(getTitle(warObject), TextOutput.OUTPUT_TABLE_WIDTH) +
                formatLine(TextOutput.PARAM, TextOutput.AMOUNT) +
                formatLine(TextOutput.COINS, String.format(TextOutput.DOUBLE_FORMAT, warObject.price())) +
                formatLine(TextOutput.KILOS, String.format(TextOutput.DOUBLE_FORMAT, warObject.weight())) +
                formatLine(TextOutput.SLICE_DAMAGE,
                        String.format(TextOutput.DOUBLE_SIGN_FORMAT, warObject.sliceDamage())) +
                formatLine(TextOutput.PIERCE_DAMAGE,
                        String.format(TextOutput.DOUBLE_SIGN_FORMAT, warObject.pierceDamage())) +
                formatLine(TextOutput.IMPACT_DAMAGE,
                        String.format(TextOutput.DOUBLE_SIGN_FORMAT, warObject.impactDamage()));
    }


    private String getTitle(WarObject warObject) {
        String[] fullClassPath = warObject.getClass().getName().split("\\.");

        return warObject.name() + '(' +
                TextOutput.AMMUNITION_TYPE.get(fullClassPath[fullClassPath.length - 1]) + ')';
    }

    private String formatTitleLine(String string, int width) {
        int startGap = 0;
        int stopGap = (width - string.length()) / 2 - 1;
        StringBuilder line = new StringBuilder(width);

        fillLineWithGAP(line, startGap, stopGap);
        line.append(string);

        startGap = stopGap + string.length();
        stopGap = width - TextOutput.NEW_LINE.length();

        fillLineWithGAP(line, startGap, stopGap);
        line.append(TextOutput.NEW_LINE);

        return line.toString();
    }

    private String formatLine(String string, String value) {
        int length = TextOutput.OUTPUT_TABLE_WIDTH;
        StringBuilder line = new StringBuilder(length);
        line.append(string);

        length -= TextOutput.NEW_LINE.length() + value.length();
        fillLineWithGAP(line, string.length(), length);

        line.append(value);
        line.append(TextOutput.NEW_LINE);

        return line.toString();
    }

    private void fillLineWithGAP(StringBuilder line, int start, int stop) {
        for (int i = start; i <= stop; i++) {
            line.append(TextOutput.TABLE_GAP_FILLER);
        }
    }
}