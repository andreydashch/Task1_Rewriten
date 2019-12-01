/*
 * @(#) Knight.java
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


package ua.training.task1.model.knight;

import ua.training.task1.model.ammunition.Ammunition;
import ua.training.task1.model.ammunition.Armor;
import ua.training.task1.model.ammunition.Weapon;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Did not implement sort!!
 * Did not implement choose!!
 *
 * @author      Dashchyk Andrey
 */
public class Knight {
    private static Body body = new Body();
    private HashMap<String, Ammunition> equipment;

    {
        equipment = new HashMap<>();

        for(String key : body.getBodyParts()) {
            equipment.put(key, null);
        }
    }

    public Knight(HashMap<String, Ammunition> equipment) {
        for(String key : equipment.keySet()) {
            this.equipment.put(key, equipment.get(key));
        }
    }

    /**
     * @return from min to max
     */
    public ArrayList<Ammunition> sortAmmunitionByPrice() {
        ArrayList<Ammunition> ammunitionList = new ArrayList<>();

        // Implement later

        return null;
    }

    /**
     * @param minBorder such as >= minBorder
     * @param maxBorder such as <= minBorder
     */
    public ArrayList<Ammunition> findAmmunitionInPriceBorders(double minBorder, double maxBorder) {
        ArrayList<Ammunition> ammunitionList = new ArrayList<>();

        // Implement later

        return null;
    }

    public double countResistPerSecond() {
        return countDamageAmountPerAttack(Armor.class);
    }

    public double countDamagePerSecond() {
        return countDamageAmountPerAttack(Weapon.class);
    }

    private double countDamageAmountPerAttack(Class test) {
        double damageAmountPerSecond = 0;
        Ammunition ammunition;

        for(String key : equipment.keySet()) {
            ammunition = equipment.get(key);

            if (test.isInstance(ammunition)) {
                damageAmountPerSecond += ammunition.getImpactDamage();
                damageAmountPerSecond += ammunition.getSliceDamage();
                damageAmountPerSecond += ammunition.getPierceDamage();
            }
        }

        return damageAmountPerSecond;
    }


}
