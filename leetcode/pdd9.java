import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] sweets = new int[m];
        int[] eated = new int[m];
        for(int i=0;i<m;i++){
            sweets[i] = scanner.nextInt();
        }
        Arrays.sort(sweets);
        int[] energy = new int[n];
        int[] hungry = new int[n];
        int[] full = new int[n];
        for(int i=0; i<n;i++){
            energy[i] = scanner.nextInt();
            hungry[i] = scanner.nextInt();
        }
        for(int i=0;i<n;i++){
            int max = Integer.MIN_VALUE;
            int p = -1;
            for(int j=0; j<n; j++){
                if(full[j] == 0 && energy[j] > max){
                    p = j;
                    max = energy[j];
                }
            }
            full[p] = 1;
            for(int j=m-1; j>=0; j--){
                if(hungry[p] >= sweets[j] && eated[j] == 0){
                    hungry[p] -= sweets[j];
                    eated[j] = 1;
                }
            }
        }
        for(int i=0; i<n;i++){
            System.out.println(hungry[i]);
        }
    }
}