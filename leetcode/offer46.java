class Solution {
    List<String> res = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();

    public String[] permutation(String s) {
        boolean[] visited = new boolean[s.length()];
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        dfs(temp, visited, 0);
        return res.toArray(new String[s.length()]);
    }

    private void dfs(char[] temp, boolean[] visited, int depth){
        if(temp.length == depth){
            res.add(sb.toString());
            return;
        }
        for(int i=0;i<temp.length;i++){
            if(visited[i]) continue;
            if(i > 0 && temp[i] == temp[i-1] && !visited[i-1]) continue;
            sb.append(temp[i]);
            visited[i] = true;
            dfs(temp, visited, depth+1);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}