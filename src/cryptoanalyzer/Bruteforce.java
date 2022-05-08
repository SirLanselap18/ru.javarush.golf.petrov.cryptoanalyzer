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
                StringBuilder stringBuilder = new StringBuilder(charsInText.size());
                for (Character character : charsInText) {
                    stringBuilder.append(character.charValue());
                }
                String[] str = stringBuilder.toString().split(" ");

                if (str.length > 0) {
                    for (String value : str) {
                        for (String s : text) {
                            if (value.equalsIgnoreCase(s)) {
                                break search;
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        out.println("Bruteforce завершён. Если результат неудовлетворительный, введите 1 для ручного подбора");
        Scanner console = new Scanner(in);
        if (console.nextInt() == 1) {
            for (int i = 0; i < CollectionData.alphabet.length; i++) {
                Decryption.decode(nameOfInputFile, nameOfOutputFile, i);
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(nameOfOutputFile)))) {
                    int c;
                    ArrayList<Character> charsInText = new ArrayList<>();
                    while ((c = reader.read()) != -1) {
                        char character = Character.toLowerCase((char) c);
                        charsInText.add(character);
                    }
                    StringBuilder stringBuilder = new StringBuilder(charsInText.size());
                    for (Character character : charsInText) {
                        stringBuilder.append(character.charValue());
                    }
                    if (stringBuilder.length() < 15) {
                        out.println("Вариант " + i + ":" + stringBuilder.substring(0, stringBuilder.length()));
                    } else {
                        out.println("Вариант " + i + ":" + stringBuilder.substring(0, 14));
                    }
                }
            }
            out.print("введите верный вариант: ");
            Decryption.decode(nameOfInputFile, nameOfOutputFile, console.nextInt());
        }
    }
}





