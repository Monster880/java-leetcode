class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int n = s.length();
        int right = 0, ans = 0;
        for(int i=0;i<n;i++){
            if(i!=0){
                set.remove(s.charAt(i-1));
            }
            while(right < n && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            ans = Math.max(ans, right - i);
        }
        return ans;
    }
}