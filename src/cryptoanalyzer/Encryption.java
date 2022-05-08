package cryptoanalyzer;

import java.io.*;

public class Encryption {

    public static void encode(String nameOfInputFile, String nameOfOutputFile, int shift) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(nameOfInputFile)));
             FileWriter fileWriter = new FileWriter(nameOfOutputFile)) {
            shift %= CollectionData.alphabet.length;
            int c;
            while ((c = reader.read()) != -1) {
                char character = Character.toLowerCase((char) c);
                char characterCipher = character;
                for (int i = 0; i < CollectionData.alphabet.length; i++) {
                    if (CollectionData.alphabet[i] == character) {
                        if (i + shift < CollectionData.alphabet.length) {
                            characterCipher = CollectionData.alphabet[i + shift];
                        } else {
                            characterCipher = CollectionData.alphabet[i + shift - CollectionData.alphabet.length];
                        }
                    }
                }
                if (characterCipher != character) {
                    fileWriter.append(characterCipher);
                    fileWriter.flush();
                } else {
                    fileWriter.append(character);
                    fileWriter.flush();
                }
            }
        }
    }
}