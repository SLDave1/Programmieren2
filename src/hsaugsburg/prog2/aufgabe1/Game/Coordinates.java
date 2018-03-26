/*
 * Copyright 2017-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package hsaugsburg.prog2.aufgabe1.Game;

/**
 * Value object which contains coordinates for inserting O or X to {@link GameWorld}.
 * @author David
 * @author Markus
 */
public class Coordinates {

    private final int _xPos;

    private final int _yPos;

    /**
     * Creates object from xPos and yPos
     * @param xPos
     * @param yPos
     */
    public Coordinates(int xPos, int yPos) {
        _xPos = xPos;
        _yPos = yPos;
    }

    /**
     * Returns symbol xPos
     * @return xPos
     */
    public int getxPos() {
        return _xPos;
    }

    /**
     * Returns symbol yPos
     * @return yPos
     */
    public int getyPos() {
        return _yPos;
    }
}
