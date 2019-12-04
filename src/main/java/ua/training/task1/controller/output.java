package ua.training.task1.controller;

import ua.training.task1.model.ammunition.Ammunition;
import ua.training.task1.model.knight.Knight;
import ua.training.task1.view.constant.TextConst;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class output {
    private final Controller controller;

    public output(Controller controller) {
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

    void formOutputLines(ArrayList<Ammunition> ammunitionArray, StringBuilder[] lines) {
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

    StringBuilder[] initialiseStringBuilderString(int arrayLength, int stringLength) {
        StringBuilder[] stringBuilderArray = new StringBuilder[arrayLength];

        for (StringBuilder stringBuilder : stringBuilderArray) {
            stringBuilder = new StringBuilder(stringLength);
        }

        return stringBuilderArray;
    }

    int countStringLines(String string) {
        int lines = 1;
        Matcher m = Pattern.compile(TextConst.NEW_LINE).matcher(string);

        while (m.find()) {
            lines++;
        }

        return lines;
    }
}