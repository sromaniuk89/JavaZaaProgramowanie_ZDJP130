import java.io.Serializable;

//jezeli chcemy serializowac dana klase to nalezy zaimplementowac interfejs znacznikowy Serializable
public class SerializableClass implements Serializable {
    float f;
    int num;
    String name;

    public SerializableClass(float f, int num, String name) {
        this.f = f;
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return "SerializableClass{" +
                "f=" + f +
                ", num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}
