import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] temp = new int[n];
        for(int i=0;i<n;i++){
            temp[i] = scanner.nextInt();
        }
        long max1 = Integer.MIN_VALUE;
        long max2 = Integer.MIN_VALUE;
        long max3 = Integer.MIN_VALUE;
        long min1 = Integer.MAX_VALUE;
        long min2 = Integer.MAX_VALUE;
        for(int m : temp){
            if(m > max1){
                max3 = max2;
                max2 = max1;
                max1 = m;
            }else if(m > max2){
                max3 = max2;
                max2 = m;
            }else if(m > max3){
                max3 = m;
            }
            if(m < min1){
                min2 = min1;
                min1 = m;
            }else if(m < min2){
                min2 = m;
            }
        }
        long res = Integer.MIN_VALUE;
        res = Math.max(res, (max1 * max2 * max3));
        res = Math.max(res, (max1 * min1 * min2));
        System.out.println(res);
    }
}