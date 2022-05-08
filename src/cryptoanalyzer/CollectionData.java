package cryptoanalyzer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.*;

public class CollectionData {
    static final char[] alphabet = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н',
            'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я',
            '.', ',', '”', ':', '-', '!', '?', ' '};

    public static String collectNameInput() {
        out.println("Имя входного файла");
        Scanner console1 = new Scanner(in);
        String nameOfInputFile = console1.nextLine();
        File fileInput = new File(nameOfInputFile);
        while (!fileInput.exists()) {
            nameOfInputFile = console1.nextLine();
            fileInput = new File(nameOfInputFile);
        }
        return nameOfInputFile;
    }

    public static String collectNameOutput(String nameOfInputFile) throws IOException {
        File fileInput = new File(nameOfInputFile);
        String pathName = fileInput.getParent();
        File fileOutput = new File(pathName + "\\output");
        if (!fileOutput.exists()) {
            fileOutput.createNewFile();
        }
        return fileOutput.getAbsolutePath();
    }

    public static int collectShift() {
        Scanner console1 = new Scanner(in);
        out.println("сдвиг для шифрования");
        return console1.nextInt();
    }

}
