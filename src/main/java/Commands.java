import java.util.List;

import static ui.Literals.ESC;

public class Commands {
    private static boolean nameCheck(String name, File whereAmI, List<File> fileSystem) {
        for (File file : fileSystem) {
            if (!file.name.equals("root")) {
                if (file.getParent().equals(whereAmI) && file.name.equals(name)) {
                    System.out.println("Папка/файл с таким именем уже существуют в этом каталоге!");
                    return false;
                }
            }
        }
        return true;
    }

    public static void createFile(File file, List<File> fileSystem) {
        if (!file.name.equals(ESC) && nameCheck(file.name, file.getParent(), fileSystem)) {
            fileSystem.add(file);
        }
    }


    public static File createDirectory(File file, List<File> fileSystem, File whereAmI) {
        if (!file.name.equals(ESC) && nameCheck(file.name, file.getParent(), fileSystem)) {
            fileSystem.add(file);
            return file;
        }
        return whereAmI;
    }


    public static void lsCommand(List<File> fileSystem, File whereAmI) {
        for (File file : fileSystem) {
            if (!file.name.equals("root")) {
                if (file.getParent().equals(whereAmI)) {
                    if (file.isFolder()) {
                        System.out.println(file.name + "/");
                    } else {
                        System.out.println(file.name);
                    }
                }
            }
        }
    }


    public static File changeDir(List<File> fileSystem, File whereAmI, String newLocation) {
        if (newLocation.equals(ESC)) {
            return whereAmI;
        }
        if (newLocation.equals("..")) {
            for (File file : fileSystem) {
                if (whereAmI.getParent().name.equals(file.name)) {
                    return file;
                }
            }
        } else {
            for (File file : fileSystem) {
                if (!file.name.equals("root")) {
                    if ((newLocation.equals(file.name)) && file.isFolder() && file.getParent().equals(whereAmI)) {
                        return file;
                    }
                }
            }
        }
        System.out.println("Папки с таким именем не существует в этой директории!");
        return whereAmI;
    }


    public static void getHierarchy(List<File> fileSystem, File whereAmI, File parentFile, int pathLength, File rootFolder) {
        String path = "\t";
        for (int i = 0; i < pathLength; i++) {
            path += "\t";
        }
        if (pathLength == 0) {
            if (whereAmI.equals(rootFolder)) {
                System.out.println(rootFolder.name + "/" + "\t\tYOU_ARE_HERE");
            } else {
                System.out.println(rootFolder.name + "/");
            }
        }
        for (File file : fileSystem) {
            if (parentFile.equals(file.getParent())) {
                if (file.isFolder()) {
                    if (whereAmI.equals(file)) {
                        System.out.println(path + file.name + "/" + "\t\tYOU_ARE_HERE");
                    } else {
                        System.out.println(path + file.name + "/");
                    }
                    pathLength += 1;
                    getHierarchy(fileSystem, whereAmI, file, pathLength, rootFolder);
                    pathLength -= 1;
                } else {
                    System.out.println(path + file.name);
                }
            }
        }
    }
}

