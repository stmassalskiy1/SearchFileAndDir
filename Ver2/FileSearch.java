import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

class FileSearch {
    public String dir; // путь до директории
    public double sizeForSearch; // минимальный размер файла или директории
    Scanner sc = new Scanner(System.in);
    ConvertByGb cbg = new ConvertByGb();
    CalculateDirSize cdz = new CalculateDirSize();
    public void fileSearchmethod() {

        System.out.print("Ввод директории для поиска: ");
        dir = sc.nextLine();
        System.out.print("Введите минимальный размер для поиска (Gb): ");

        sizeForSearch = sc.nextDouble();
        File file = new File(dir);
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile() && cbg.convertBytesToGb(f.length())>=sizeForSearch) {
                    System.out.println("Файл: " + f.getAbsoluteFile() + "\n" +
                            " Размер: " +  String.format("%.2f", cbg.convertBytesToGb(f.length())) + " Gb");
                } else if (f.isDirectory()) {
                    long dirSize=cdz.calculateDirSize(f);
                    if(cbg.convertBytesToGb(dirSize)>=sizeForSearch) {
                        System.out.println("Директория " + f.getAbsoluteFile() + "\n" +
                                " Размер: " + String.format("%.2f", cbg.convertBytesToGb(dirSize)) + " Gb");
                    }

                }
            }

        }
    }
}
