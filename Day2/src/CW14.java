import java.util.*;

public class CW14 {
    public static void main(String[] args) {
        Integer[] integers = new Integer[100_000];

        Random random = new Random();

        for(int i=0; i<integers.length; i++){
            integers[i] = random.nextInt(100_000);
        }

        //wyswietle tylko pierwsze np. 500 elementow
        for(int i=0; i<integers.length/200; i++)
            System.out.println("["+i+"]"+ ": " + integers[i]);

        //1
        List<Integer> uniqueElements = getUniqueElements(integers);

        for(int i=0; i<uniqueElements.size()/200; i++)
            System.out.println("unique ["+i+"]"+ ": " + uniqueElements.get(i));

        System.out.println("length of integers table: " + integers.length);
        System.out.println("size of uniqueElements list: " + uniqueElements.size());

        //2
        List<Integer> repeatedElements = getRepeatedElements(integers);
        System.out.println("length of integers table: " + integers.length);
        System.out.println("size of uniqueElements list: " + uniqueElements.size());
        System.out.println("size of repeatedElements list: " + repeatedElements.size());

        //3
        find25MostFrequentRepeats(integers);
    }

    //1
    public static List<Integer> getUniqueElements(Integer[] integerTable) {
        //tworzymy liste z tablicy wejsciowej, a nastepnie tak utworzona lista podawana jest jakos argument
        //konstruktora zbioru HashSet<>();
        Set<Integer> uniqueIntegers = new HashSet<>(Arrays.asList(integerTable));

        //zwracamy liste integerow wykorzystujac stworzony przed chwila zbior
        return new LinkedList<>(uniqueIntegers);
    }

    //2
    public static List<Integer> getRepeatedElements(Integer[] integerTable){
        List<Integer> uniqueIntegers = getUniqueElements(integerTable);
        List<Integer> integerList = new LinkedList<>(Arrays.asList(integerTable)); //tworzymy liste z tablicy wejsciowej

        //usuwamy wszystkie elementy unikalne z listy
        //integerList.removeAll(uniqueIntegers);//ta metoda usunie wszystkie wystapienia w integerList - nie poprawne

        for(Integer n : uniqueIntegers){
            integerList.remove(n); //usunie pierwsze wystapienie w integerList
        }

        Set<Integer> repeatedValuesFromList = new HashSet<>(integerList);

        return new LinkedList<>(repeatedValuesFromList);
    }

    public static List<Integer> find25MostFrequentRepeats(Integer[] integers){
        Map<Integer, Integer> occurenciesOfValues = new HashMap<>();

        for(Integer a : integers){
            if(occurenciesOfValues.containsKey(a)){//sprawdzamy czy w mapie znajduje sie juz dana wartosc
                //pobieramy liczbe wystapien danej wartosci z mapy a nastepnie zwiekszamy ja o 1
                //wstawiajac do mapy nowa wartosc pod dany klucz ktory juz w tej mapie sie znajduje
                //w mapie dalej bedzie tylko jeden dany unikalny klucz ale wartosc tego klucza zostanie zaktualizowana
                occurenciesOfValues.put(a, occurenciesOfValues.get(a) + 1);
            } else {
                occurenciesOfValues.put(a, 1);
            }
        }

        Set<Map.Entry<Integer,Integer>> entries = occurenciesOfValues.entrySet();

        int i =0;
        for(Map.Entry<Integer,Integer> entry: occurenciesOfValues.entrySet()){
            System.out.println(entry);
            if(++i>500)
                break;
        }

        //tutaj posortowac mape po wartosciach (od najwiekszej do najmniejszej)
        //a potem zwrocic 25 najczesciej powtarzajacych sie wartosci w postaci listy
        return new LinkedList<>();
    }
}
