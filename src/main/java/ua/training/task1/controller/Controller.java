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

import ua.training.task1.model.knight.Knight;
import ua.training.task1.view.TextOutput;
import ua.training.task1.view.View;

/**
 * @author      Dashchyk Andrey
 */
public class Controller {
    private final Output output = new Output(this);
    private final Input input = new Input();
    private View view;

    public Controller(View view){
        this.view = view;
    }

    /**
     * Get input from properties file
     * Check all functionality of Knight class
     * Output knight data with View
     */
    public void processUser(){
        int minBorder = 100;
        int maxBorder = 170;
        Knight knight;


        knight = input.createKnight(Const.CONFIG_FILE_NAME);
        knight.sharpenAllWeapons(1.2);

        output.printAmmunitionArrayList(knight.sortAmmunitionByPrice(), TextOutput.SORT_LIST_MESSAGE);
        output.printAmmunitionArrayList(knight.findAmmunitionInPriceRange(minBorder, maxBorder),
                TextOutput.FIND_LIST_MESSAGE);

        view.printlnMessage(TextOutput.DAMAGE_PER_SECOND_MESSAGE);
        view.printlnMessage(Double.toString(knight.countDamagePerSecond()));
        view.printlnMessage(TextOutput.RESIST_PER_SECOND_MESSAGE);
        view.printlnMessage(Double.toString(knight.countResistPerSecond()));

        view.printlnMessage(TextOutput.NEW_LINE + TextOutput.NEW_LINE);


    }

    View getView() {
        return view;
    }
}