import java.util.*;

class Node{
    int x,y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] nodes = new Node[n];
        for(int i=0;i<n;i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            nodes[i] = new Node(x,y);
        }
        int res = 0;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if((nodes[j].y - nodes[i].y) * (nodes[k].x - nodes[i].x) != ((nodes[k].y - nodes[i].y) * (nodes[j].x - nodes[i].x))){
                        res++;
                    }
                }
            }
        }
        System.out.println(res);
    }
}