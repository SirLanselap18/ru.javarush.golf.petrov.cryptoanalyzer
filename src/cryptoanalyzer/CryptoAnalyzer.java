package cryptoanalyzer;

import java.io.*;
import java.util.Scanner;

import static java.lang.System.*;

public class CryptoAnalyzer {
    static char[] alphabet = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н',
            'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я',
            '.', ',', '”', ':', '-', '!', '?', ' '};

    public static void main(String[] args) throws IOException {
        out.println("Введите желаемое действие");
        out.println("1. Шифрование");
        out.println("2. Расшифровка");
        out.println("3. Криптоанализ путём bruteforce");
        Scanner console = new Scanner(in);
        int choose = console.nextInt();
        while (choose > 3 || choose < 1) {
            out.println("Повторите ввод");
            choose = console.nextInt();
        }
        if (choose == 1) {
            Scanner console1 = new Scanner(in);
            out.println("Имя входного файла");
            String nameOfInputFile = console1.nextLine();
            File fileInput = new File(nameOfInputFile);
            String pathName = fileInput.getParent();
            while (!fileInput.exists()) {
                nameOfInputFile = console1.nextLine();
                fileInput = new File(nameOfInputFile);
                pathName = fileInput.getParent();
            }
            File fileOutput = new File(pathName + "\\output");
            if (!fileOutput.exists()) {
                fileOutput.createNewFile();
            }
            String nameOfOutputFile = fileOutput.getAbsolutePath();
            out.println("сдвиг для шифрования");
            int shift = console1.nextInt();
            Encryption.encode(nameOfInputFile, nameOfOutputFile, shift);

        } else if (choose == 2) {
            Scanner console1 = new Scanner(in);
            out.println("Имя входного файла");
            String nameOfInputFile = console1.nextLine();
            File fileInput = new File(nameOfInputFile);
            String pathName = fileInput.getParent();
            while (!fileInput.exists()) {
                nameOfInputFile = console1.nextLine();
                fileInput = new File(nameOfInputFile);
                pathName = fileInput.getParent();
            }
            File fileOutput = new File(pathName + "\\output");
            if (!fileOutput.exists()) {
                fileOutput.createNewFile();
            }
            String nameOfOutputFile = fileOutput.getAbsolutePath();
            out.println("сдвиг для шифрования");
            int shift = console1.nextInt();
            Decryption.decode(nameOfInputFile, nameOfOutputFile, shift);
        } else if (choose == 3) {
            Scanner console1 = new Scanner(in);
            out.println("Имя входного файла");
            String nameOfInputFile = console1.nextLine();
            File fileInput = new File(nameOfInputFile);
            String pathName = fileInput.getParent();
            while (!fileInput.exists()) {
                out.println("Файл не существует");
                nameOfInputFile = console1.nextLine();
                fileInput = new File(nameOfInputFile);
                pathName = fileInput.getParent();
            }
            File fileOutput = new File(pathName + "\\output");
            if (!fileOutput.exists()) {
                fileOutput.createNewFile();
            }
            String nameOfOutputFile = fileOutput.getAbsolutePath();
            Bruteforce.bruteforceAttack(nameOfInputFile, nameOfOutputFile);
        }


    }


}



