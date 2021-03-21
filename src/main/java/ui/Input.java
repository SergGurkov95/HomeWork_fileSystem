package ui;

import java.util.Scanner;

public class Input {
    public static String inputCommand(Scanner scanner) {
        System.out.println("Введите команду(CreateFile/CreateDirectory/Hierarchy/cd/ls/Exit):");
        return scanner.nextLine();
    }

    public static String name(Scanner scanner) {
        System.out.println("Введите имя файла/папки или Esc:");
        return scanner.nextLine();
    }

    public static String newLocation(Scanner scanner) {
        System.out.println("Введите \"..\" для выхода на 1 уровень вверх, или введите название папки для перехода в неё:");
        return scanner.nextLine();
    }
}
