package com.company;

import java.util.ArrayList;
import java.beans.XMLDecoder;
import java.io.*;

public class GameLoader {
    public static SavedGame loadGameFromFile(String fileName) {
        try {
            XmlDecoder decoder = new XmlDecoder(new BufferedInputStream(new FileInputStream(fileName)));
            SavedGame savedGame = (SavedGame) decoder.readObject();
            decoder.close();
            return savedGame;
        } catch(Exception ex) {
            System.out.println("An error occurred while reading this file!");
        }
    }
}
