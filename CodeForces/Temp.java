import java.util.*;
import java.util.stream.Collectors;

class Temp {
    public static void main(String[] arg) {
        Integer[] ar = {1,3,4,5,6,7,8,9,10,11,14};

        List<Integer> al = Arrays.asList(ar);
        
        al = al.stream().
                map(x -> x+3).
                filter(x-> x%3 == 0).
                collect(Collectors.toList());

        List<Integer> all = Arrays.asList(ar);
        all = all.stream().
                map(x-> x+3).
                filter(x->x%3 == 0).
                collect(Collectors.toCollection(LinkedList<Integer>::new));
        
        for(int i = 0; i < all.size();)
            System.out.println(((LinkedList<Integer>)all).removeLast());
            
    }
}