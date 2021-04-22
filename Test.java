import java.util.Set;
import java.util.List;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<Integer>();
        a.add(1);
        a.add(3);
        a.add(2);

        // successful
        Set<Integer> b = new HashSet<Integer>();
        b.add(5);
        b.add(2);
        b.add(7);
        b.add(3);
        b.add(1);
        System.out.println(b.containsAll(a));

        ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        System.out.println(b.containsAll(e));

        List<Integer> f = Arrays.asList(1, 2, 3);
        System.out.println(f);
        System.out.println(a.containsAll(f));

        List<Integer> tRow = Arrays.asList(1, 2, 3);
        List<Integer> mRow = Arrays.asList(4, 5, 6);
        List<Integer> bRow = Arrays.asList(7, 8, 9);
        List<Integer> lCol = Arrays.asList(1, 4, 7);
        List<Integer> mCol = Arrays.asList(2, 5, 8);
        List<Integer> rCol = Arrays.asList(3, 6, 9);
        List<Integer> tDia = Arrays.asList(1, 5, 9);
        List<Integer> bDia = Arrays.asList(7, 5, 3);

        List<List> winner = new ArrayList<List>();
        winner.add(tRow);
        winner.add(mRow);
        winner.add(bRow);
        winner.add(lCol);
        winner.add(mCol);
        winner.add(rCol);
        winner.add(tDia);
        winner.add(bDia);
        for (List l : winner) {
            if (a.containsAll(l)) {
                System.out.println("We have a Winner!");
            }
        }

    }
}
