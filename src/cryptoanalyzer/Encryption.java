package cryptoanalyzer;

import java.io.*;

public class Encryption {

    public static void encode(String nameOfInputFile, String nameOfOutputFile, int shift) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(nameOfInputFile)));
             FileWriter fileWriter = new FileWriter(nameOfOutputFile)) {
            shift %= CryptoAnalyzer.alphabet.length;
            int c;
            while ((c = reader.read()) != -1) {
                char character = Character.toLowerCase((char) c);
                char characterCipher = character;
                for (int i = 0; i < CryptoAnalyzer.alphabet.length; i++) {
                    if (CryptoAnalyzer.alphabet[i] == character) {
                        if (i + shift < CryptoAnalyzer.alphabet.length) {
                            characterCipher = CryptoAnalyzer.alphabet[i + shift];
                        } else {
                            characterCipher = CryptoAnalyzer.alphabet[i + shift - CryptoAnalyzer.alphabet.length];
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