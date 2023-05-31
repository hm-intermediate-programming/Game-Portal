package Games;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public interface Game {
    String getGameName();

    void play(); // must be able to play a game

}
