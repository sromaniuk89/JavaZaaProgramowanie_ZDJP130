import java.io.File;

public class CW33 {
    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\Sławomir\\Desktop\\SDA\\Nowy program\\Java zaawansowana - programowanie\\CW33";

        searchForPngJpgFiles(directoryPath);
    }

    private static void searchForPngJpgFiles(String path){
        File file = new File(path);

        File[] filesPNG = file.listFiles(f->f.getName().endsWith(".png")); //zwróci pliki png
        File[] filesJPG = file.listFiles(f->f.getName().endsWith(".jpg")); //zwróci pliki jpg
        File[] directories = file.listFiles(f->f.isDirectory()); //tutaj zwroci wszystkie foldery/katalog

        for(File f: filesPNG)
            System.out.println(path+"\\"+f.getName());

        for(File f:filesJPG)
            System.out.println(path+"\\"+f.getName());

        for(File f:directories)
            searchForPngJpgFiles(path+"\\"+f.getName());

    }
}
