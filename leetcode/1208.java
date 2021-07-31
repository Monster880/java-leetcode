class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int maxLength = 0;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += diff[end];
            while (sum > maxCost) {
                sum -= diff[start];
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }
}