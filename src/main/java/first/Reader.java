package first;

import java.io.*;
import java.util.Scanner;

public class Reader {
    private String values;
    private static final String PATH = "src/main/resources/test2.csv";

    public static void main(String[] args) {
        Reader reader = new Reader();
        reader.openFile(PATH);
    }

    private void openFile(String path) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            reader.mark(100);
            System.out.println("Для перехода к следующей записи введите n. Для перехода к первой записи введите f");
            while (reader.ready()) {
                values = reader.readLine();
                if (!values.isEmpty()) {
                    String scanner = new Scanner(System.in).nextLine();
                    if (next(scanner)) {
                        System.out.println(values);
                    }
                    if (first(scanner)) {
                        reader.reset();
                        values = reader.readLine();
                        System.out.println(values);
                    }
                }
            }
            System.out.println("Чтение закончено");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean first(String command) {
        return command.equals("f");
    }

    private boolean next(String command) {
        return command.equals("n");
    }

}
