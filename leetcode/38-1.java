class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        else{
            String str = countAndSay(n-1);
            StringBuilder sb = new StringBuilder();
            int i=0, j=1, len = str.length();
            while(j < len){
                if(str.charAt(i) != str.charAt(j)){
                    sb.append(j-i).append(str.charAt(i));
                    i = j;
                }
                j++;
            }
            sb.append(j - i).append(str.charAt(i));
            return sb.toString();
        }
    }
}