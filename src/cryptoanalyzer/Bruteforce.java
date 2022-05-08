package cryptoanalyzer;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;


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

        boolean success = false;

        search:
        for (int i = 0; i < CollectionData.alphabet.length; i++) {
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
                    if (str.length > 0) {
                        for (String value : str) {
                            for (String s : text) {
                                if (value.equalsIgnoreCase(s)) {
                                    success = true;
                                    break search;
                                }
                            }
                        }
                    }
                    else if ((double)charsInText.size() / str.length > 5 && (double) charsInText.size() / str.length < 6) {
                        {
                            out.println(charsInText);
                            out.println(str.length);
                            out.println((double)charsInText.size() / str.length);
                            success = true;
                            break search;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (success) {
            out.println("Брутфорс проведён успешно!");
        } else {
            out.println("Непохоже, что брутфорс удался автоматически, введите верный вариант вручную");
        }

    }
}




