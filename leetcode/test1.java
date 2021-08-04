import java.util.*;

class Main{
    public String Decode(String a){
        int[][] res = new int[a.size()/6+1][6];
        int index = 0;
        int length = a.size();
        for(int i=0;i<length/6+1;i++){
            for(int j=0;j<6;j++){
                res[i][j] = a.charAt(index++) - "a";
            }
        }
        int[] s = new int[6];
        for(int j=0;j<6;j++){
            int sum = 0;
            for(int i=0;i<length/6+1;i++){
                sum += res[i][j];
            }
            s[j] = sum;
        }
        int[] ret = new int[6];
        int k = 0;
        for(int j=0;j<6;j++){
            int temp = s[j];
            while(temp >= 10){
                detralize(temp);
            }
            ret[k++] = temp;
        }
        String b = "";
        for(int j=0;j<6;j++){
            b.append(ret[j]);
        }
        return b;
    }

    public int detralize(int a){
        int temp = a;
        int sum = 0;
        while(temp !=0){
            int num = temp % 10;
            temp /= 10;
            sum += num;
        }
        return sum;
    }
}