class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ind = new int[numCourses];
        Map<Integer, List<Integer>> oud = new HashMap<>();
        for(int[] p : prerequisites){
            List<Integer> d = oud.getOrDefault(p[1], new ArrayList<>());
            d.add(p[0]);
            oud.put(p[1], d);
            ind[p[0]]++;
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(ind[i] == 0){
                q.add(i);
            }
        }
        int[] ans = new int[numCourses];
        int n = 0;
        while(!q.isEmpty()){
            int x = q.poll();
            ans[n++] = x;
            for(int y : oud.getOrDefault(x, new ArrayList<>())){
                if(--ind[y] == 0){
                    q.add(y);
                }
            }
        }
        return n == numCourses ? ans : new int[0];
    }
}