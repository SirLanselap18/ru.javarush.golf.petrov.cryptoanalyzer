package cryptoanalyzer;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Bruteforce {

    public static void bruteforceAttack(String nameOfInputFile, String nameOfOutputFile) throws IOException {

        ArrayList<String> text = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("dictionary.txt"))) {
            while (scanner.hasNextLine()) {
                text.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        search:
        for (int i = 0; i < CryptoAnalyzer.alphabet.length; i++) {
            Decryption.decode(nameOfInputFile, nameOfOutputFile, i);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(nameOfOutputFile)))) {
                int c;
                ArrayList<Character> charsInText = new ArrayList<>();
                while ((c = reader.read()) != -1) {
                    char character = Character.toLowerCase((char) c);
                    charsInText.add(character);
                }
                try (Scanner scanner = new Scanner(new File(nameOfOutputFile))) {
                    String[] str = new String[charsInText.size() / 3];
                    while (scanner.hasNextLine()) {
                        str = scanner.nextLine().split(" ");
                    }
                    if (str.length > 1) {
                        for (String value : str) {
                            for (String s : text) {
                                if (value.equalsIgnoreCase(s)) {
                                    break search;
                                }
                            }
                        }
                    } else if (charsInText.size() / str.length >= 3 && charsInText.size() / str.length < 7) {
                        {
                            break search;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}




