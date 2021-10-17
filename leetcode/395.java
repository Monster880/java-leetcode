class Solution {
    public int longestSubstring(String s, int k) {
        int res = 0;
        int n = s.length();
        for(int i=1; i <= 26; i++){
            int left = 0, right = 0;
            int[] temp = new int[26];
            int total = 0;
            int charNum = 0;
            while(right < n){
                temp[s.charAt(right) - 'a']++;
                if(temp[s.charAt(right) - 'a'] == 1){
                    total++;
                    charNum++;
                }
                if(temp[s.charAt(right) - 'a'] == k){
                    charNum--;
                }
                while(total > i){
                    temp[s.charAt(left) - 'a']--;
                    if(temp[s.charAt(left) - 'a'] == k -1){
                        charNum++;
                    }
                    if(temp[s.charAt(left) - 'a'] == 0){
                        total--;
                        charNum--;
                    }
                    left++;
                }
                if(charNum == 0){
                    res = Math.max(res, right - left + 1);
                }
                right++;
            }
        }
        return res;
    }
}