class Solution {
    private int m;

    private String dfs(StringBuilder sb, int n){
        if(sb.length() == n){
            return --m == 0 ? sb.toString() : "";
        }
        for(char c = 'a'; c<= 'c'; c++){
            if(sb.length() == 0 || sb.charAt(sb.length()-1) != c){
                sb.append(c);
                String temp = dfs(sb,n);
                if(temp != ""){
                    return temp;
                }
                sb.setLength(sb.length()-1);
            }
        }
        return "";
    }

    public String getHappyString(int n, int k) {
        m = k;
        return dfs(new StringBuilder(),n);
    }
}