class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> res = new ArrayList<>();
        if(n < m) return res;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for(int i = 0; i < m; i++){
            pCount[p.charAt(i) - 'a'] ++;
        }

        int left = 0;
        for(int right = 0; right < n; right++){
            int curRight = s.charAt(right) - 'a';
            sCount[curRight]++;
            while(sCount[curRight] > pCount[curRight]){
                int curLeft = s.charAt(left) - 'a';
                sCount[curLeft]--;
                left++;
            }
            if(right - left + 1 == m){
                res.add(left);
            }
        }
        return res;
    }
}