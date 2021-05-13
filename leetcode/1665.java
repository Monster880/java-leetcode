class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a,b)->{
            return b[1] - b[0] - (a[1] - a[0]);
        });
        int r = 0, e = 0;
        for(int[] t: tasks){
            e -= t[1];
            r = Math.max(r, -e);
            e += t[1] - t[0];
        }
        return r;
    }
}