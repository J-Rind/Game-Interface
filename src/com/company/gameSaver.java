package com.company;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class gameSaver {
    public static void write(saveGame saveGame, Player player) {
        String fileName = player + LocalDateTime.now().toString() + ".xml";
        try {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("fileName")));
            encoder.writeObject(saveGame);
            encoder.close();
        } catch (Exception ex) {
            System.out.println("An error occurred while writing to the file");
        }
    }
}
