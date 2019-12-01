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
    protected String name;
    protected double weight;
    protected double price;
    protected double wearOn;
    protected double sliceDamage;
    protected double pierceDamage;
    protected double impactDamage;

    protected Ammunition(String name, double weight, double price, double wearOn) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.wearOn = wearOn;
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

    public double getWearOn() {
        return wearOn;
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
        return "Equipment\n" +
                getName() + "\n" +
                getPrice() + " Coins\n" +
                getWeight() + " Kilos\n";
    }
}
