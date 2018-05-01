import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class milk2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("milk2.in"));
        int n = sc.nextInt();
        ArrayList<Interval> items = new ArrayList<>();
        for(int i = 0; i< n; i++){
            sc.nextLine();
            items.add(new Interval(sc.nextInt(),sc.nextInt()));
        }
        Collections.<Interval>sort(items);
        for(int i = 0; i< items.size()-1; i++){
            Interval item1 = items.get(i); Interval item2 = items.get(i+1);

        }
        System.out.println(items);
    }
    static class Interval implements Comparable{
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public int compareTo(Object item2){
            return this.start- ((Interval)item2).start;
        }
        public String toString(){
            return "" + start+" "+ end;
        }

    }
}