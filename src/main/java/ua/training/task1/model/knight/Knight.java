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
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Did not implement sort!!
 * Did not implement choose!!
 *
 * @author      Dashchyk Andrey
 */
public class Knight {
    private static final HashSet<String> bodyPartsNames;
    private Body body;

    static {
        bodyPartsNames = new HashSet<>();

        bodyPartsNames.add("head");
        bodyPartsNames.add("chest");
        bodyPartsNames.add("arms");
        bodyPartsNames.add("leftHand");
        bodyPartsNames.add("rightHand");
    }

    {
        body = new Body(bodyPartsNames);
    }

    public Knight(HashMap<String, Ammunition> equipment) {
        for(String key : equipment.keySet()) {
            body.wearAmmunitionOnExistBodyPart(key, equipment.get(key));
        }
    }

    public static HashSet<String> getBodyPartsNames() {
        return bodyPartsNames;
    }

    /**
     * @return from min to max
     */
    public ArrayList<Ammunition> sortAmmunitionByPrice() {
        ArrayList<Ammunition> ammunitionList = new ArrayList<>();

        // Implement later
        ammunitionList.add(body.getAmmunitionFromBodyPart("head"));

        return ammunitionList;
    }

    /**
     * @param minBorder such as >= minBorder
     * @param maxBorder such as <= minBorder
     */
    public ArrayList<Ammunition> findAmmunitionInPriceRange(double minBorder, double maxBorder) {
        ArrayList<Ammunition> ammunitionList = new ArrayList<>();

        // Implement later
        ammunitionList.add(body.getAmmunitionFromBodyPart("head"));

        return ammunitionList;
    }

    public double countResistPerSecond() {
        return countDamageAmountPerAttack(Armor.class);
    }

    public double countDamagePerSecond() {
        return countDamageAmountPerAttack(Weapon.class);
    }

    private double countDamageAmountPerAttack(Class subClass) {
        double damageAmountPerSecond = 0;
        Ammunition ammunition;

        for(String key : body.getBodyPartsNames()) {
            ammunition = body.getAmmunitionFromBodyPart(key);

            if (subClass.isInstance(ammunition)) {
                damageAmountPerSecond += ammunition.getImpactDamage();
                damageAmountPerSecond += ammunition.getSliceDamage();
                damageAmountPerSecond += ammunition.getPierceDamage();
            }
        }

        return damageAmountPerSecond;
    }



}
