import ui.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ui.Literals.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<File> fileSystem = new ArrayList<>();

        File root = new File("root", true, null);
        File whereAmI = root;
        fileSystem.add(root);

        String input;
        int pathLength;
        boolean appState = true;


        while (appState) {
            input = Input.inputCommand(scanner);
            pathLength = 0;

            switch (input) {
                case (CREATE_FILE):
                    Commands.createFile(new File(Input.name(scanner), false, whereAmI), fileSystem);
                    break;
                case (CREATE_DIRECTORY):
                    whereAmI = Commands.createDirectory(new File(Input.name(scanner), true, whereAmI), fileSystem, whereAmI);
                    break;
                case (HIERARCHY):
                    Commands.getHierarchy(fileSystem, whereAmI, root, pathLength, root);
                    break;
                case (CHANGE_DIR):
                    whereAmI = Commands.changeDir(fileSystem, whereAmI, Input.newLocation(scanner));
                    break;
                case (LS):
                    Commands.lsCommand(fileSystem, whereAmI);
                    break;
                case (EXIT):
                    appState = false;
                    break;
                default:
                    System.out.println("Неверный ввод!");

            }
        }
    }
}