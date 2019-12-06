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

import java.util.Objects;

/**
 * Super class with no access
 *
 * @author      Dashchyk Andrey
 */
public class Ammunition implements Comparable<Ammunition> {
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
        return this.name;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getPrice() {
        return this.price;
    }

    public double getSliceDamage() {
        return this.sliceDamage;
    }

    public double getPierceDamage() {
        return this.pierceDamage;
    }

    public double getImpactDamage() {
        return this.impactDamage;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ammunition that = (Ammunition) obj;
        return Double.compare(that.weight, weight) == 0 &&
                Double.compare(that.price, price) == 0 &&
                Double.compare(that.sliceDamage, sliceDamage) == 0 &&
                Double.compare(that.pierceDamage, pierceDamage) == 0 &&
                Double.compare(that.impactDamage, impactDamage) == 0 &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, price, sliceDamage, pierceDamage, impactDamage);
    }

    @Override
    public int compareTo(Ammunition that) {
        int compare;

        if (this.price < that.price){
            compare = -1;
        } else {
            compare = 0;
        }

        return compare;
    }
}
