package com.company;

import java.beans.XMLEncoder;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.io.*;

public class GameSaver {
    public static void saveGame(SaveGame saveGame, Player player) {
        String fileName = player + "-" + LocalDateTime.now().toString() + ".xml";
        try {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
            encoder.writeObject(saveGame);
            encoder.close();
        } catch (Exception ex) {
            System.out.println("An error occurred while writing to the file");
        }
    }
}
