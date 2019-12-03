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

import ua.training.task1.model.ammunition.Ammunition;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author      Dashchyk Andrey
 */
class Body {
    private HashSet<BodyPart> bodyParts;

    public Body(Set<String> names) {
        bodyParts = new HashSet<>();

        for(String name : names) {
            bodyParts.add(new BodyPart(name));
        }
    }

    public boolean wearAmmunitionOnExistBodyPart(String bodyPartName, Ammunition ammunition) {
        for(BodyPart bodyPart : bodyParts) {
            boolean existBodyPart = bodyPartName.hashCode() == bodyPart.hashCode();

            if (existBodyPart) {
                bodyPart.setAmmunition(ammunition);

                return true;
            }
        }

        return false;
    }

    public Ammunition getAmmunitionFromBodyPart(String bodyPartName) {
        for(BodyPart bodyPart : bodyParts) {
            boolean existBodyPart = bodyPartName.hashCode() == bodyPart.hashCode();

            if (existBodyPart) {


                return bodyPart.getAmmunition();
            }
        }

        return null;
    }

    public HashSet<String> getBodyPartsNames() {
        HashSet<String> names = new HashSet<>();

        for(BodyPart bodyPart : bodyParts) {
            names.add(bodyPart.getName());
        }

        return names;
    }
}

class BodyPart {
    private String name;
    private Ammunition ammunition;


    public BodyPart(String name) {
        this.name = name;
    }

    public void setAmmunition(Ammunition ammunition) {
        this.ammunition = ammunition;
    }

    public Ammunition getAmmunition() {
        return ammunition;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BodyPart bodyPart = (BodyPart) o;

        return name.equals(bodyPart.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}