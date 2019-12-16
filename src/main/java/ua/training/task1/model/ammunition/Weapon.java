/*
 * @(#) Weapon.java
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
 * @author      Dashchyk Andrey
 */
public class Weapon extends Ammunition implements Sizable{
    private boolean sharpening;

    protected Weapon(String name, double weight, double price,
                     double sliceDamage, double pierceDamage, double impactDamage) {
        super(name, weight, price);
        this.sharpening = false;
        this.sliceDamage = sliceDamage;
        this.pierceDamage = pierceDamage;
        this.impactDamage = impactDamage;
    }

    /**
     * Multiplicand sliceDamage and coefficient (only one time)
     */
    @Override
    public void sharpen(double coefficient) {
        if (!sharpening) {
            sharpening = true;
            sliceDamage *= coefficient;
        }
    }

}
