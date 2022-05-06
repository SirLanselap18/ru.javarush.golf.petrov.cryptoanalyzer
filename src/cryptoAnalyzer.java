import java.io.*;
import java.util.Scanner;

public class cryptoAnalyzer {
    static char[] alphabet = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н',
            'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я',
            '.', ',', '”', ':', '-', '!', '?', ' '};


    public static void main(String[] args) throws IOException {
        System.out.println("Введите желаемое действие");
        System.out.println("1. Шифрование");
        System.out.println("2. Расшифровка");
        System.out.println("3. Криптоанализ путём bruteforce");
        Scanner console = new Scanner(System.in);
        int choose = console.nextInt();
        while (choose > 3 | choose < 1) {
            System.out.println("Повторите ввод");
            choose = console.nextInt();
        }
        if (choose == 1) {
            Scanner console1 = new Scanner(System.in);
            System.out.println("Имя входного файла");
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
            System.out.println("сдвиг для шифрования");
            int shift = console1.nextInt();
            Encrypter.Encryption(nameOfInputFile, nameOfOutputFile, shift);

        } else if (choose == 2) {
            Scanner console1 = new Scanner(System.in);
            System.out.println("Имя входного файла");
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
            System.out.println("сдвиг для шифрования");
            int shift = console1.nextInt();
            Decryptor.Decryption(nameOfInputFile, nameOfOutputFile, shift);
        } else if (choose == 3) {
            Scanner console1 = new Scanner(System.in);
            System.out.println("Имя входного файла");
            String nameOfInputFile = console1.nextLine();
            File fileInput = new File(nameOfInputFile);
            String pathName = fileInput.getParent();
            while (!fileInput.exists()) {
                System.out.println("Файл не существует");
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


