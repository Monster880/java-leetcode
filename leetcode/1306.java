class Solution {
    public boolean canReach(int[] arr, int start) {
        if(arr[start] == 0){
            return true;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int n = arr.length;
        boolean[] mark = new boolean[n];
        mark[start] = true;
        while(!q.isEmpty()){
            int x = q.poll();
            for(int i=0; i<2;i++){
                int y = x + (i == 0 ? arr[x] : -arr[x]);
                if(y >= 0 && y < n){
                    if(arr[y] == 0){
                        return true;
                    }
                    if(!mark[y]){
                        q.add(y);
                        mark[y] = true;
                    }
                }
            }
        }
        return false;
    }
}