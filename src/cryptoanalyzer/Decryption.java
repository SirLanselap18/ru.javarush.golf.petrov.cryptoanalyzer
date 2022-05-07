package cryptoanalyzer;

import java.io.*;

public class Decryption {

    public static void decode(String nameOfInputFile, String nameOfOutputFile, int shift) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(nameOfInputFile)));
             FileWriter fileWriter = new FileWriter(nameOfOutputFile)) {
            shift %= CryptoAnalyzer.alphabet.length;
            int c;
            while ((c = reader.read()) != -1) {
                char character = Character.toLowerCase((char) c);
                char decodedCharacter = character;
                for (int i = 0; i < CryptoAnalyzer.alphabet.length; i++) {
                    if (CryptoAnalyzer.alphabet[i] == character) {
                        if (i - shift >= 0) {
                            decodedCharacter = CryptoAnalyzer.alphabet[i - shift];
                            fileWriter.flush();
                        } else {
                            decodedCharacter = CryptoAnalyzer.alphabet[i - shift + CryptoAnalyzer.alphabet.length];
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