import java.util.Scanner;
 
public class Main{
     
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[] array=new long[n];
        for(int i=0;i<n;i++){
            array[i]=sc.nextLong();
        }
 
        getTheMostValue(array,n);
    }
     
    public static void getTheMostValue(long[] num,int len){
        long max1=0;long max2=0;long max3=0;long min1=0;long min2=0;
         
        for(int i=0;i<len;i++){
            if(num[i]>max1){
                max3=max2;
                max2=max1;
                max1=num[i];
            }else if(num[i]>max2){
                max3=max2;
                max2=num[i];
            }else if(num[i]>max3){
                max3=num[i];
            }else if(num[i]<min1){
                min2=min1;
                min1=num[i];
            }else if(num[i]>min1&&num[i]<min2){
                min2=num[i];
            }
        }
         
        long max=Math.max(max1*max2*max3,max1*min1*min2);
        System.out.println(max);
    }
}