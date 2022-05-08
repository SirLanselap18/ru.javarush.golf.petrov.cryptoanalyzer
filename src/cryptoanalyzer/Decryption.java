package cryptoanalyzer;

import java.io.*;

public class Decryption {

    public static void decode(String nameOfInputFile, String nameOfOutputFile, int shift) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(nameOfInputFile)));
             FileWriter fileWriter = new FileWriter(nameOfOutputFile)) {
            shift %= CollectionData.alphabet.length;
            int c;
            while ((c = reader.read()) != -1) {
                char character = Character.toLowerCase((char) c);
                char decodedCharacter = character;
                for (int i = 0; i < CollectionData.alphabet.length; i++) {
                    if (CollectionData.alphabet[i] == character) {
                        if (i - shift >= 0) {
                            decodedCharacter = CollectionData.alphabet[i - shift];
                            fileWriter.flush();
                        } else {
                            decodedCharacter = CollectionData.alphabet[i - shift + CollectionData.alphabet.length];
                        }
                    }
                }
                if (decodedCharacter != character) {
                    fileWriter.append(decodedCharacter);
                    fileWriter.flush();
                } else {
                    fileWriter.append(character);
                    fileWriter.flush();
                }
            }
        }
    }
}