package cryptoanalyzer;

import java.io.*;

public class Decryption {

    public static void decode(String nameOfInputFile, String nameOfOutputFile, int shift) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(nameOfInputFile)));
             FileWriter fileWriter = new FileWriter(nameOfOutputFile)) {
            shift %= cryptoAnalyzer.alphabet.length;
            int c;
            while ((c = reader.read()) != -1) {
                char character = Character.toLowerCase((char) c);
                char decodedCharacter = character;
                for (int i = 0; i < cryptoAnalyzer.alphabet.length; i++) {
                    if (cryptoAnalyzer.alphabet[i] == character) {
                        if (i - shift >= 0) {
                            decodedCharacter = cryptoAnalyzer.alphabet[i - shift];
                            fileWriter.flush();
                        } else {
                            decodedCharacter = cryptoAnalyzer.alphabet[i - shift + cryptoAnalyzer.alphabet.length];
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