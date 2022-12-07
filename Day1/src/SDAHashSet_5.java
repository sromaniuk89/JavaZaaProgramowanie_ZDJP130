import java.io.Serializable;
import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SDAHashSet_5<E> extends AbstractSet<E> implements Set<E>, Serializable {
    private HashMap<E, Object> map;

    private static final Object O = new Object(); //stala ktora dziala tylko jako znacznik

    public SDAHashSet_5() {
        map = new HashMap<>();
    }

    public boolean add(E e){
        return map.put(e, O)==null;//jesli dany element sie znajdowal w mapie to zwrocony zostanie false
    }

    public boolean remove(Object e){
        return map.remove(e)==O;//jesli dany element byl w mapie to zwrocony zostanie true
//        return map.remove(e, O);
    }

    public int size(){
        return map.size();//zwracamy rozmiar mapy, uwzglednia liczbe kluczy
    }

    public boolean contains(Object e){
        return map.containsKey(e);//sprawdzamy czy dany element znajduje sie w mapie
    }

    public void clear(){
        map.clear();
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }
}
