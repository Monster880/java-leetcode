class Solution {
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (a,b)->{
            return a[0] == b[0] ? (a[1] - b[1]) : (a[0] - b[0]);
        });
        int num=0, right=0;
        for(int left=0, i=0; right < T && i<clips.length; left=right, num++){
            for(;right < T && i<clips.length && clips[i][0] <= left; right = Math.max(clips[i++][1], right));
            if(right == left){
                return -1;
            }
        }
        return right >= T ? num : -1;
    }
}