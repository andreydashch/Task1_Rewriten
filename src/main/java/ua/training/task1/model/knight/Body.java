/*
 * @(#) Body.java
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

import ua.training.task1.InitBodyParts;
import ua.training.task1.model.ammunition.Ammunition;
import ua.training.task1.model.ammunition.WarObject;

import java.util.EnumSet;
import java.util.HashSet;

/**
 * @author      Dashchyk Andrey
 */
class Body {
    private HashSet<BodyPart> bodyParts;

    public Body(EnumSet<InitBodyParts> names) {
        bodyParts = new HashSet<>();

        for(InitBodyParts name : names) {
            bodyParts.add(new BodyPart(name.toString()));
        }
    }

    /**
     * If bodyPartName exist in bodyParts set, warObject aggregate to this part
     * and do nothing if not
     */
    public void wearAmmunitionOnExistBodyPart(String bodyPartName, WarObject warObject) {
        BodyPart bodyPart = findBodyPart(bodyPartName);

        if (bodyPart != null) {
            bodyPart.setWarObject(warObject);
        }
    }

    public HashSet<String> getBodyPartsNames() {
        HashSet<String> names = new HashSet<>();

        for(BodyPart bodyPart : bodyParts) {
            names.add(bodyPart.getName());
        }

        return names;
    }

    public WarObject getWarObjectFromBodyPart(String bodyPartName) {
        return findBodyPart(bodyPartName).getWarObject();
    }

    private BodyPart findBodyPart(String bodyPartName) {
        BodyPart searchingBodyPart = null;

        for(BodyPart bodyPart : bodyParts) {
            boolean existBodyPart = bodyPartName.hashCode() == bodyPart.hashCode();

            if (existBodyPart) {
                searchingBodyPart = bodyPart;
            }
        }

        return  searchingBodyPart;
    }
}

class BodyPart {
    private String name;
    private WarObject warObject;

    public BodyPart(String name) {
        this.name = name;
    }

    public void setWarObject(WarObject warObject) {
        this.warObject = warObject;
    }

    public WarObject getWarObject() {
        return warObject;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        BodyPart bodyPart = (BodyPart) obj;

        return name.equals(bodyPart.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}