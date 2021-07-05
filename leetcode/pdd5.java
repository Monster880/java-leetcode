import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int offset=sc.nextInt();
        int n=sc.nextInt();
        int l1=sc.nextInt();
        int l2=sc.nextInt();
        showList(offset,n,l1,l2);
    }
    public static void showList(int offset,int n,int l1,int l2){
        if(offset <= l1 + l2){
            // 表明起点在L2表中
            if (offset >= l1){
                if (offset+n >= l1 + l2){
                    // 表明总长度大于L1，L2列表长度和
                    System.out.print(l1 + " " + l1 + " " + (offset-l1) + " " + l2);
                } else {
                    // 表明长度小于L1，L2列表长度和
                    System.out.print(l1 + " " + l1 + " " + (offset-l1) + " " + (offset+n-l1));
                }
            } else if(offset+n<=l1){
                //表明展示的数据全部来自L1
                System.out.print(offset + " " + (offset+n) + " 0 0");
            } else if (offset<l1){
                // 来自两表
                System.out.print(offset + " " + l1 + " 0 " + (offset+n-l1));
            }
        } else {
            // 表示两表跳过
            System.out.print(l1+" "+l1+" "+l2+" "+l2);
        }
    }
}