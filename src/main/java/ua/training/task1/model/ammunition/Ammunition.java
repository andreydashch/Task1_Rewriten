/*
 * @(#) Ammunition.java
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


package ua.training.task1.model.ammunition;

/**
 * Super class with no access
 *
 * @author      Dashchyk Andrey
 */
public class Ammunition {
    String NEW_LINE = "\n";
    String GAP = " ";

    protected String name;
    protected double weight;
    protected double price;
    protected double sliceDamage;
    protected double pierceDamage;
    protected double impactDamage;

    protected Ammunition(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public double getSliceDamage() {
        return sliceDamage;
    }

    public double getPierceDamage() {
        return pierceDamage;
    }

    public double getImpactDamage() {
        return impactDamage;
    }

    @Override
    public String toString() {
        int length = 20;

        String fullClassPath = getClass().getName();

        return  formatOutputLine(fullClassPath, length) +
                formatOutputLine(getName(), length) +
                formatOutputLine("Coins", getPrice(), length) +
                formatOutputLine("Kilos", getWeight(), length);
    }

    private String formatOutputLine(String string, int length) {
        StringBuilder line = new StringBuilder(length);
        line.append(string);

        length -= NEW_LINE.length();
        for(int i=string.length();i <= length;i ++) {
            line.append(GAP);
        }
        line.append(NEW_LINE);

        return  line.toString();
    }

    private String formatOutputLine(String string, double value, int length) {
        String valueString;
        valueString = String.format("%06.2f", value);
        length -= valueString.length();

        StringBuilder line = new StringBuilder(length);
        line.append(string);

        length -= NEW_LINE.length() + valueString.length();
        for(int i=string.length();i <= length - 1;i ++) {
            line.append(GAP);
        }

        line.append(valueString);
        line.append(NEW_LINE);
        return  line.toString();
    }
}
