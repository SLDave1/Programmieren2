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

package hsaugsburg.prog2.aufgabe1;

import hsaugsburg.prog2.aufgabe1.Game.Game;
import hsaugsburg.prog2.aufgabe1.Game.GameState;
import hsaugsburg.prog2.aufgabe1.Game.GameWorld2D;
import hsaugsburg.prog2.aufgabe1.Game.Score;
import hsaugsburg.prog2.aufgabe1.IO.Console;

public class Main {

    public static void main(String[] args) {
        new Game(new Console(), new GameState(new GameWorld2D(), new Score())).Run();
    }
}
