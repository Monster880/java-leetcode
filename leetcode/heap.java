import java.util.*;

public class Main{

    public static void main(String[] args){
        heapSort(temp);
    }

    private void buildHeadp(int[] temp, int length){
        for(int i=length/2; i>=0;i--){
            adjustDown(temp,i,length);
        }
    }

    private void heapSort(int[] temp){
        int length = temp.length;
        buildHeadp(temp,length);
        for(int i=0;i<length;i++){
            System.out.println(temp[i]);
            swap(temp[0], temp[i])
            adjustDown(temp,0,length-1);
        }
    }

    private void adjustDown(int[] temp,int k, int length){
        temp[0] = temp[k];
        for(int i=2*k; i<=length;i *= 2){
            if(i < length && temp[i] < temp[i+1]) i++;
            if(temp[0] >= temp[i]) break;
            else{
                swap(temp[k], temp[i]);
                k=i;
            }
        }
        temp[k] = temp[0];
    }
}