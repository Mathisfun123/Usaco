/*
ID: sairaja
LANG: JAVA
TASK: transform
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class transform {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner( new File("transform.in"));
        PrintWriter out = new PrintWriter(new File("transform.out"));
        int n = sc.nextInt();
        sc.nextLine();
        char intialmaze[][] = new char[n][n];
        char finalmaze [][] = new char[n][n];
        for(int i = 0; i< n; i++){
            String sg = sc.nextLine();
            int size = sg.length();
            for(int j= 0;j< size; j++){
                intialmaze[i][j] = sg.charAt(j);
            }
        }
        for(int i = 0; i< n; i++){
            String sg = sc.nextLine();
            int size = sg.length();
            for(int j= 0;j< size; j++){
                finalmaze[i][j] = sg.charAt(j);
            }
        }
        boolean transformation [] = new boolean[8];
        if(checkSameMaze(intialmaze, finalmaze)){
            transformation[6] = true;
        }
        char newmaze [][]  =returnRotateMaze(intialmaze);
        if(checkSameMaze(newmaze,finalmaze)){
            transformation[1]= true;
        }
        newmaze = returnRotateMaze( newmaze);
        if(checkSameMaze(newmaze,finalmaze)){
            transformation[2]= true;
        }
        newmaze = returnRotateMaze( newmaze);
        if(checkSameMaze(newmaze,finalmaze)){
            transformation[3]= true;
        }
        if(n % 2 ==0){
            int mid = n/2;
            /*for(int i = 0; i< mid; i++){
                char []temp = intialmaze[i];
                for(int j = 0; j < n; j++){
                     newmaze[j][i] = newmaze[n-j-1][i];
                     newmaze[n-i-1][j]= temp[j];
                }
            }*/
                for (int j = 0; j < n-1; j++)
                    for (int i = 0; i < mid; i++)
                    {
                        newmaze[i][j] = intialmaze[n-1-i][j];
                    }
            if(checkSameMaze(newmaze,finalmaze)){
                transformation[4]= true;
            }
           newmaze = returnRotateMaze(intialmaze);
            if(checkSameMaze(newmaze,finalmaze)){
                transformation[5]= true;
            }
            newmaze = returnRotateMaze( newmaze);
            if(checkSameMaze(newmaze,finalmaze)){
                transformation[5]= true;
            }
            newmaze = returnRotateMaze( newmaze);
            if(checkSameMaze(newmaze,finalmaze)){
                transformation[5]= true;
            }
        }else{
            int mid = n/2;
            for (int j = 0; j < n; j++)
                for (int i = 0; i < mid; i++)
                {
                    newmaze[i][j] = intialmaze[n-1-i][j];
                }
            if(checkSameMaze(newmaze,finalmaze)){
                transformation[4]= true;
            }
            if(checkSameMaze(newmaze,finalmaze)){
                transformation[5]= true;
            }
            newmaze = returnRotateMaze( newmaze);
            if(checkSameMaze(newmaze,finalmaze)){
                transformation[5]= true;
            }
            newmaze = returnRotateMaze( newmaze);
            if(checkSameMaze(newmaze,finalmaze)){
                transformation[5]= true;
            }
        }

        boolean happend = false;
        for(int i =1 ; i< transformation.length; i++){
            if(!happend && transformation[i]){
                out.println(i);
                happend= true;
            }
        }
        if(!happend){
            out.println(7);
        }
        out.close();

    }
    public static char[][] returnRotateMaze(char [][] intialmaze2){
        char[][] check = new char[intialmaze2.length][intialmaze2.length];
        for(int i  = 0; i< intialmaze2[0].length;i++){
            for(int j = intialmaze2.length-1; j>=0;j-- ){
                check[i][j] = intialmaze2[intialmaze2.length- (j+1)][i];
            }
        }
        return check;
    }
    public static boolean checkSameMaze (char [][] item1, char item2[][]){
        for(int i = 0; i< item2.length; i++){
            for(int j = 0; j< item2[i].length; j++){
                if(item1[i][j]!=item2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}