import java.io.*;
import java.util.LinkedList;

public class JavaIOSerialization {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Sławomir\\Desktop\\SDA\\Nowy program\\Java - zaawansowana\\JavaIO_NIO\\serializedObject.txt";

        SerializableClass serializableClass1 = new SerializableClass(1.23f, 30, "firstObject");
        SerializableClass serializableClass2 = new SerializableClass(2.46f, 60, "secondObject");

        LinkedList<SerializableClass> serializableClasses = new LinkedList<>();
        serializableClasses.add(serializableClass1);
        serializableClasses.add(serializableClass2);

        //zapis stanu obiektu do pliku
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath))) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(serializableClasses);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //odczyt obiektu z pliku
        try(FileInputStream fileInputStream = new FileInputStream(new File(filePath))){
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            //odczytujemy obiekt z pliku po czym rzutujemy go na wlasciwa klase (wlasciwy typ)
            LinkedList<SerializableClass> serializableClassesFromFile = (LinkedList<SerializableClass>) objectInputStream.readObject();
            System.out.println(serializableClassesFromFile);
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}