import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CW2 {
    public static void main(String[] args) {

        List<String> exampleList = Arrays.asList("abc", "ZYX", "xyz", "mnp", "Dag"); //przykładowa lista

        System.out.println(sortFromZToA(exampleList));
        System.out.println(sortListWithoutCase(exampleList));
    }

    public static List<String> sortFromZToA(List<String> list){
        return list.stream()
                .map(x -> x.toLowerCase())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private static List<String> sortListWithoutCase(List<String> list) {
        //task 2
        list.sort(Comparator.comparing(String::toLowerCase));
        Collections.reverse(list);
        return list;
    }

    public static List<String> stringListSortCaseInsensitive(List<String> list) {
        //sortowanie w odwrotnej kolejnosci
        //Collections.sort(stringList, Collections.reverseOrder());
        Collections.sort(list, (x,y)->y.toLowerCase().compareTo(x.toLowerCase()));

        return list;
    }
}
