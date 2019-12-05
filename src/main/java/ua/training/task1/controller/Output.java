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
    int LINE_LENGTH = 21;
    String NEW_LINE = "\n";
    String GAP = " ";
    private final Controller controller;

    public Output(Controller controller) {
        this.controller = controller;
    }

    void printAmmunitionArrayList(ArrayList<Ammunition> ammunitionArray) {
        int arrayLength, stringLength;
        StringBuilder[] lines;

        arrayLength = Ammunition.class.getDeclaredFields().length + 1;
        stringLength = LINE_LENGTH;
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
            ammunitionString = makeAmmunitionString(ammunition);

            for (String linePart : ammunitionString.split(TextConst.NEW_LINE)) {
                lines[index].append(linePart);
                lines[index].append(TextConst.TABLE_SEPARATOR);
                index ++;
            }
        }
    }

    private StringBuilder[] initialiseStringBuilderString(int arrayLength, int stringLength) {
        StringBuilder[] stringBuilderArray = new StringBuilder[arrayLength];

        for (int i=0;i <= stringBuilderArray.length - 1;i ++) {
            stringBuilderArray[i] = new StringBuilder(stringLength);
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

    private String makeAmmunitionString(Ammunition ammunition) {
        String title = getTitle(ammunition);

        return  formatTitleLine(title, LINE_LENGTH) +
                formatLine("Param", "Amount", LINE_LENGTH) +
                formatLine("Coins", String.format("%06.2f", ammunition.getPrice()), LINE_LENGTH) +
                formatLine("Kilos", String.format("%06.2f", ammunition.getWeight()), LINE_LENGTH) +
                formatLine("sliceDamage", String.format("%+06.2f", ammunition.getSliceDamage()), LINE_LENGTH) +
                formatLine("pierceDamage", String.format("%+06.2f", ammunition.getPierceDamage()), LINE_LENGTH) +
                formatLine("impactDamage", String.format("%+06.2f", ammunition.getImpactDamage()), LINE_LENGTH);
    }


    String getTitle(Ammunition ammunition) {
        String[] fullClassPath = getClass().getName().split("\\.");

        return ammunition.getName() +
                '(' +
                fullClassPath[fullClassPath.length - 1] +
                ')';
    }

    String formatTitleLine(String string, int length) {
        StringBuilder line = new StringBuilder(length);
        int firstFinishPosition = (length - string.length()) / 2;

        fillLineWithGAP(line, 0, firstFinishPosition);
        line.append(string);
        fillLineWithGAP(line, firstFinishPosition + string.length(), length - NEW_LINE.length());
        line.append(NEW_LINE);

        return line.toString();
    }

    String formatLine(String string, String value, int length) {
        StringBuilder line = new StringBuilder(length);
        line.append(string);

        length -= NEW_LINE.length() + value.length();
        fillLineWithGAP(line, string.length(), length);

        line.append(value);
        line.append(NEW_LINE);

        return line.toString();
    }

    void fillLineWithGAP(StringBuilder line, int start, int stop) {
        for (int i = start; i <= stop; i++) {
            line.append(GAP);
        }
    }
}