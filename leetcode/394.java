class Solution {
    public String decodeString(String s) {
        return dfs(s, 0)[0];
    }

    private String[] dfs(String s, int i){
        StringBuffer res = new StringBuffer();
        int multi = 0;
        while(i < s.length()){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                multi = multi * 10 + s.charAt(i) - '0';
            }else if(s.charAt(i) == '['){
                String[] temp = dfs(s, i+1);
                i = Integer.parseInt(temp[0]);
                while(multi > 0){
                    res.append(temp[1]);
                    multi--;
                }
            }else if(s.charAt(i) == ']'){
                return new String[]{String.valueOf(i), res.toString()};
            }else{
                res.append(String.valueOf(s.charAt(i)));
            }
            i++;
        }
        return new String[]{res.toString()};
    }
}