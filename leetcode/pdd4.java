import java.util.*;

public class Main {
	
	static class Node{
		int x;
		int y;
		int key;
		int step;
		public Node(int x,int y,int key,int step){
			this.x=x;
			this.y=y;
			this.key=key;
			this.step=step;
		}
	}
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int m=scanner.nextInt();
		scanner.nextLine();
		char[][] Graph=new char[n][m];
		for(int i=0;i<n;i++){
			Graph[i]=scanner.nextLine().toCharArray();
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(Graph[i][j]=='2'){
					System.out.println(bfs(i,j,n,m,Graph));
					return;
				}
			}
		}
	}
	private static int bfs(int xi, int yj,int n,int m,char[][] Graph) {
		Queue<Node> queue=new LinkedList<>();
		int[][][] temp=new int[101][101][1025];
		int[][] next={{-1,0},{0,-1},{1,0},{0,1}};
		
		queue.offer(new Node(xi,yj,0,0));
		while(!queue.isEmpty()){
			Node node=queue.poll();
			for(int i=0;i<4;i++){
				int x=node.x+next[i][0];
				int y=node.y+next[i][1];
				int key=node.key;
                
				if(x<0||x>=n||y<0||y>=m||Graph[x][y]=='0') continue;
				else if(Graph[x][y]=='3') return node.step+1;
				else if(Graph[x][y]<='z'&&Graph[x][y]>='a') key=key|((1<<Graph[x][y]-'a'));
				else if(Graph[x][y]<='Z'&&Graph[x][y]>='A'&&(key&(1<<(Graph[x][y]-'A')))==0) continue;
				if(temp[x][y][key]==0){
					temp[x][y][key]=1;
					queue.offer(new Node(x,y,key,node.step+1));
				}
				
			}
		}
		return -1;
	}
	
}
