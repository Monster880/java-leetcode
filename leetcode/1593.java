class Solution {
    private int r = 1;

    private void dfs(String s, HashSet<String> all, int now){
        if(s.length() -now + all.size() <= r){
            return;
        }
        if(s.length() == now){
            r = all.size();
            return;
        }
        for(int i= now +1; i<=s.length();i++){
            String temp = s.substring(now,i);
            if(!all.contains(temp)){
                all.add(temp);
                dfs(s,all,i);
                all.remove(temp);
            }
        }
    }

    public int maxUniqueSplit(String s) {
        r = 1;
        dfs(s, new HashSet<String>(), 0);
        return r;
    }
}