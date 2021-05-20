class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        String ans = s;
        Queue<String> q = new LinkedList<>();
        Set<String> all = new HashSet<>();
        all.add(s);
        for(q.add(s); !q.isEmpty();){
            s = q.poll();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length(); i++){
                sb.append((i & 1) == 0 ? s.charAt(i) : (char)(((s.charAt(i) - '0' + a)% 10) + '0'));
            }
            String temp = sb.toString();
            if(all.add(temp)){
                if(ans.compareTo(temp) > 0){
                    ans = temp;
                }
                q.add(temp);
            }
            temp = s.substring(s.length() - b) + s.substring(0, s.length() - b);
            if(all.add(temp)){
                if(ans.compareTo(temp) > 0){
                    ans = temp;
                }
                q.add(temp);
            }
        }
        return ans;
    }
}