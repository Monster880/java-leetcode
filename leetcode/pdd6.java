import java.util.*;
import java.io.*;
public class Main {
    static class TreeNode {
        int val;
        int parent = -1;
        //把子节点和权值分开存储
        ArrayList<TreeNode> child = new ArrayList<>();
        ArrayList<Integer> dist = new ArrayList<>();
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limit = scanner.nextInt();
        int n = scanner.nextInt();
        TreeNode[] treeNodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            treeNodes[i] = new TreeNode(i);
        }
        for (int i = 0; i < n - 1; i++) {
            int parent = scanner.nextInt();
            int child = scanner.nextInt();
            int dist = scanner.nextInt();
            treeNodes[parent].child.add(treeNodes[child]);
            treeNodes[child].parent = parent;
            treeNodes[parent].dist.add(dist);
        }
        //找到根节点
        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            if (treeNodes[i].parent == -1) {
                root = treeNodes[i];
                break;
            }
        }
        HashSet<Integer> set = getPath(root, limit);
        int max = Integer.MIN_VALUE;
        for (int len : set) {
            max = Math.max(max, len);
        }
        System.out.println(max);
    }
    private static HashSet<Integer> getPath(TreeNode root, int limit) { //limit不变
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        if (root == null) return set;
        //保持连通是通过从子树往上递归
        ArrayList<HashSet<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < root.child.size(); i++) {
            HashSet<Integer> childSet = getPath(root.child.get(i), limit); //以第一个参数为根节点的处理方法
            arr.add(childSet);
        }
        // one path
        for (int i = 0; i < arr.size(); i++) {
            int d = root.dist.get(i);
            //最少选一条路
            for (int path : arr.get(i)) {
                if (path + d <= limit) set.add(path + d);
            }
            //最多选两条
            for (int j = i + 1; j < arr.size(); j++) {
                int d2 = root.dist.get(j);
                for (int path1 : arr.get(i)) {
                    for (int path2 : arr.get(j)) {
                        if (path1 + path2 + d + d2 <= limit) set.add(path1 + path2 + d + d2);
                    }
                }
            }
        }
        return set;
    }
}
