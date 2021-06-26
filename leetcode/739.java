class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for(int i=length -1; i>=0; i--){
            int warmerIndex = Integer.MAX_VALUE;
            for(int t= temperatures[i] + 1; t <= 100; t++){
                if(next[t] < warmerIndex){
                    warmerIndex = next[t];
                }
            }
            if(warmerIndex < Integer.MAX_VALUE){
                ans[i] = warmerIndex - i;
            }
            next[temperatures[i]] = i;
        }
        return ans;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<length; i++){
            int temperature = temperatures[i];
            while(!s.isEmpty() && temperature > temperatures[s.peek()]){
                int preIndex = s.pop();
                ans[preIndex] = i - preIndex;
            }
            s.push(i);
        }
        return ans;
    }
}