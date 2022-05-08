package cryptoanalyzer;

import java.io.*;
import java.util.Scanner;

import static java.lang.System.*;

public class CryptoAnalysis {

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
            String inputFile = CollectionData.collectNameInput();
            Encryption.encode(inputFile, CollectionData.collectNameOutput(inputFile), CollectionData.collectShift());
        } else if (choose == 2) {
            String inputFile = CollectionData.collectNameInput();
            Decryption.decode(inputFile, CollectionData.collectNameOutput(inputFile), CollectionData.collectShift());
        } else {
            String inputFile = CollectionData.collectNameInput();
            Bruteforce.bruteforceAttack(inputFile, CollectionData.collectNameOutput(inputFile));
        }
    }
}



