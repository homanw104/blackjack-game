# Blackjack Game

A single-player blackjack game designed using
OOAD practices, powered by **JavaFX**.

## Features

The application contains two scene: playroom-bet-view and playroom-game-view,
each has a corresponding controller manipulating the Game, the Player,
the Dealer and the Deck! Player can stand, double or hit during the game.
Splitting is not yet supported.

![img_0.png](assets/img_0.png)
![img_1.png](assets/img_1.png)
![img_2.png](assets/img_2.png)

## Build and Run

Run this project by executing the maven target `javafx:run`.
If you wish to build this project into an executable (a jar file),
you have to manually set up an artifact in **Project Structure...** in IDEA.
Check [Help On JavaFX](https://jetbrains.com/help/idea/javafx.html)
from *IntelliJ IDEA Edu* to get to know about JavaFX project structure.

## Packaging

Before packaging, you need to [download](https://gluonhq.com/products/javafx/)
OpenJFX libraries since JavaFX is no longer bundled in JDK since version 9.
Note that only the latest version of JavaFX can be downloaded,
LTS version downloads are paid services.

To produce a standalone jar executable:

1. In **Project Structure**, go to **Artifacts** tab on the left.
2. Click the **+** button at the top, select **JAR** |
   **From modules with dependencies...**
3. Select the **Main Class** which is NOT extended from
   the `Application` class (a packaging bug workaround),
   in this case, `BlackjackLauncher`. Then click **OK**.
4. In the artifact setup you just created, click the **+**
   button in **Output Layout**, select **File**.
5. Browse to the directory where you installed/extracted `javafx-sdk`,
   under `/bin` directory, hold `Shift` and select all `*.dll` files,
   click **OK**.
6. Now you can build the artifact in your IDEA by selecting **Build** |
   **Build Artifacts...** | **Build**, the output file is under
   `/out/artifacts`

If you also wish to convert the jar file into a Windows executable,
you could use [launch4j](http://launch4j.sourceforge.net/).
