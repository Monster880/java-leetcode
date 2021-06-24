class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int n = heights.length;
        int r = 0;
        for(int i=0; i < n;i++){
            for(; !s.isEmpty() && heights[s.peek()] >= heights[i];){
                r= Math.max(r, heights[s.pop()] * (i - (s.isEmpty() ? (-1) : s.peek()) - 1 ));
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            r= Math.max(r, heights[s.pop()] * (n - (s.isEmpty() ? (-1) : s.peek()) - 1 ));
        }
        return r;
    }
}