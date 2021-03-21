public class File {
    public String name;
    private boolean isFolder;
    private File parent;

    public File(String name, boolean isFolder, File parent) {
        this.name = name;
        this.isFolder = isFolder;
        this.parent = parent;
    }

    public File getParent() {
        return parent;
    }

    public boolean isFolder() {
        return isFolder;
    }
}
