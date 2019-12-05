/*
 * @(#) TextConst.java
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


package ua.training.task1.view;

/**
 * @author      Dashchyk Andrey
 */
public class TextOutput {
    public static String TABLE_GAP_FILLER;
    public static String NEW_LINE;
    public static String TABLE_SEPARATOR;
    public static String AMOUNT;
    public static String PARAM;
    public static String COINS;
    public static String KILOS;
    public static String DAMAGE;
    public static String SLICE_DAMAGE;
    public static String PIERCE_DAMAGE;
    public static String IMPACT_DAMAGE;
    public static int OUTPUT_TABLE_WIDTH;

    static {
        update();
    }

    static void update() {
        TABLE_GAP_FILLER = View.resourceBundle.getString("TABLE_GAP_FILLER");
        NEW_LINE = View.resourceBundle.getString("NEW_LINE");
        TABLE_SEPARATOR = View.resourceBundle.getString("TABLE_SEPARATOR");
        AMOUNT = View.resourceBundle.getString("AMOUNT");
        PARAM = View.resourceBundle.getString("PARAM");
        COINS = View.resourceBundle.getString("COINS");
        KILOS = View.resourceBundle.getString("KILOS");
        DAMAGE = View.resourceBundle.getString("DAMAGE");
        SLICE_DAMAGE = View.resourceBundle.getString("SLICE") + DAMAGE;
        PIERCE_DAMAGE = View.resourceBundle.getString("PIERCE") + DAMAGE;
        IMPACT_DAMAGE = View.resourceBundle.getString("IMPACT") + DAMAGE;
        OUTPUT_TABLE_WIDTH = Integer.parseInt(View.resourceBundle.getString("OUTPUT_TABLE_WIDTH"));
    }                                                    
}
