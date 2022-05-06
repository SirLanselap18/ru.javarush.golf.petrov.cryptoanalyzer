import java.io.*;

public class Decryptor {
    public static void Decryption(String nameOfInputFile, String nameOfOutputFile, int shift) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(nameOfInputFile)));
        FileWriter fileWriter = new FileWriter(nameOfOutputFile);
        shift %= cryptoAnalyzer.alphabet.length;
        int c;
        while ((c = reader.read()) != -1) {
            char character = Character.toLowerCase((char) c);
            for (int i = 0; i < cryptoAnalyzer.alphabet.length; i++) {
                if (cryptoAnalyzer.alphabet[i] == character) {
                    if (i - shift >= 0) {
                        fileWriter.append(cryptoAnalyzer.alphabet[i - shift]);
                        fileWriter.flush();
                    } else {
                        fileWriter.append(cryptoAnalyzer.alphabet[i - shift + cryptoAnalyzer.alphabet.length]);
                        fileWriter.flush();
                    }
                }
            }
        }
    }
}
