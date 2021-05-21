class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> all = new HashMap<>();
        int n = arr.length;
        int[] b = new int[n];
        for(int i=0; i<n; i++){
            List<Integer> temp = all.getOrDefault(arr[i], new ArrayList<>());
            temp.add(i);
            all.put(arr[i], temp);
            b[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        for(b[0] = 0; b[n-1]<0;){
            int x = q.poll();
            if(x > 0 && b[x-1] < 0){
                b[x-1] = b[x] + 1;
                q.add(x-1);
            }
            if(x+1 < n && b[x+1] < 0){
                b[x+1] = b[x] + 1;
                q.add(x+1);
            }
            for(int y : all.getOrDefault(arr[x], new ArrayList<>())){
                if(b[y] < 0){
                    b[y] = b[x] + 1;
                    q.add(y);
                }
            }
            all.remove(arr[x]);
        }
        return b[n-1];
    }
}