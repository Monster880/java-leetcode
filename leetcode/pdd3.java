import java.util.*;
 
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] h = new int[n];
        for(int i=0; i<n; i++){
            h[i] = sc.nextInt();
        }
        
        int m = sc.nextInt();
        int[] w = new int[m];
        for(int i=0; i<m; i++)
            w[i] = sc.nextInt();
        
        System.out.println(helper(h, w));
    }
    
    private static int helper(int[] h, int[] w){
        Arrays.sort(h);
        Arrays.sort(w);
        int res = 0;
        int i = 0, j = 0;
        
        while(i < w.length && j < h.length){
            if(w[i] >= h[j]){
                res++;
                j++;
            }
            
            i++;
        }
        
        return res;
    }
}