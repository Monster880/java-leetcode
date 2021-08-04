// 双向链表
// 数据结构的定义
// 实现两个函数
// 第一个函数是查找结点（查找相等的一列结点）
// 第二个函数是插入时对结点从大到小的排序

import java.util.*;



class Main{
    public int staic n = 100000;

    class TreeNode{
        int val;
        TreeNode next;
        TreeNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    
    class Deque{
    
        int length;
        int value;
        TreeNode root;
        TreeNode next;
    
        public TreeNode[] get(int value){
            TreeNode[] list = new TreeNode[n];
            TreeNode temp = root;
            while(temp != null){
                if(temp.value == value){
                    list.add(temp);
                }
                temp = temp.next;
                if(temp.value < value){
                    return list;
                }
            }
            return list;
        }
    
        public boolean insert(TreeNode temp){
            int value = temp.value;
            TreeNode nodeRoot = root;
            TreeNode preRoot;
            while(nodeRoot.value >= temp.value){
                preRoot = nodeRoot;
                nodeRoot = nodeRoot.next;
            }
            preRoot.next = temp;
            temp.next = nodeRoot;
            this.length = this.length+1;
        }

        public boolean Deque(TreeNode temp){
            this.root = temp;
            this.length = this.length+1;
        }
    }
}
