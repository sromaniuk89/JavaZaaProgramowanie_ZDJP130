import java.util.*;

public class Storage_4 {
    private HashMap<String, List<String>> map;

    public Storage_4() {
        map = new HashMap<>();
    }

    public void addToStorage(String key, String value){
        if(map.containsKey(key)){
            //jezeli dany klucz w mapie juz istnieje
            map.get(key).add(value); //to uzupelniamy liste o nowy element (pod danym wpisem)
        } else {
            //jezeli danego klucza w mapie nie ma
            //to wstawiamy nowy wpis
            //tym wpisem jest para <String, List<String>> czyli oczywiscie taki sam typ jak typ mapy
            //czyli nalezy tutaj utworzyc nowa liste
            map.put(key, new ArrayList<>(Arrays.asList(value))); //mutowalne
            //map.put(key, Arrays.asList(value)); //niemutowalne - nie bedzie mozna dodawac nowych elementow
        }
    }

    public boolean printValues(String key){
        if(map.containsKey(key)) { //sprawdzamy czy mamy dany klucz
            System.out.println(map.get(key)); //wyswietlanie elementow z pobranej listy spod danego klucza

            return true;
        }

        return false;
    }

    public boolean findValues(String value){
        boolean found = false;

        //petla do przeszukiwania wszystkich wartosci z naszej mapy
        for(Map.Entry<String, List<String>> entry : map.entrySet()){ //z mapy pobieramy wpisy
            for(String s : entry.getValue()){ //pobieramy kolejne stringi z listy
                if(s.equals(value)){//sprawdzamy czy dana wartosc zostala znaleziona
                    System.out.print(entry.getKey()+"; "); //wypisanie wartosci klucza
                    found = true;
                    break; //czyli zeby nie powtarzac wielokrotnie nazwy danego klucza, przechodzimy do kolejnego wpisu
                }
            }

            //inny sposob
//            if(entry.getValue().contains(value)){
//                System.out.print(entry.getKey()+"; "); //wypisanie wartosci klucza
//                found = true;
//            }
        }

        //rozwiazanie z lambda
//        map.forEach((k,v)->{
//            if(v.contains(value)){
//                System.out.println(k);
//            }
//        });

        if(!found){
            System.out.println("Value not found");
        } else {
            System.out.println();
        }

        return found;
    }

}
