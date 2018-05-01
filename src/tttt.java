import javax.print.attribute.HashAttributeSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class tttt {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("tttt.in"));
        PrintWriter out = new PrintWriter( new File("tttt.out"));
        char mat [] [] = new char[3][3];
        for(int i = 0; i< 3; i++){
            String ln = sc.nextLine();
            for(int j = 0; j< 3; j++){
                mat[i][j]= ln.charAt(j);
            }
        }
        String item1 = "" + mat[0][0]+ mat[0][1]+ mat[0][2];
        String item2 = "" + mat[2][0]+ mat[2][1]+ mat[2][2];
        String item3 = "" + mat[0][0]+ mat[1][0]+ mat[2][0];
        String item4 = "" + mat[0][2]+ mat[1][2]+ mat[2][2];
        String item5 = "" + mat[0][0]+ mat[1][1]+ mat[2][2];
        String item6 = "" + mat[0][2]+ mat[1][1]+ mat[2][0];
        String item7 = "" + mat[0][1]+ mat[1][1]+ mat[2][1];
        String item8 = "" + mat[1][0]+ mat[1][1]+ mat[1][2];
        String arr[] = {item1,item2,item3,item4, item5, item6,item7,item8};
        int onecownumbertime = 0;
        Set <String> twoTeam = new TreeSet<>();
        HashSet <String> oneTeam = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            if(s.charAt(1)==s.charAt(0)){
                if (s.charAt(2) == s.charAt(1)) {
                    if(!oneTeam.contains(s.substring(0,1))){
                        onecownumbertime++;
                        oneTeam.add((s.substring(0,1)));
                    }
                }else{
                    char [] item = s.substring(1,3).toCharArray();
                    Arrays.sort(item);
                    String itemString = new String(item);
                    twoTeam.add(itemString);
                }
            }else{
                if(s.charAt(1)==s.charAt(2)){
                    char [] item = s.substring(0,2).toCharArray(); Arrays.sort(item);
                    String itemString = new String(item);
                    twoTeam.add(itemString);
                }
                if(s.charAt(2)==s.charAt(0)){
                    char [] item = s.substring(0,2).toCharArray(); Arrays.sort(item);
                    String itemString = new String(item);
                    twoTeam.add(itemString);
                }
            }
        }
        out.println(onecownumbertime);
        out.println(twoTeam.size());
        out.close();
    }
}
