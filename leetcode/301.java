class Solution {
    private int len;
    private char[] sArray;
    private Set<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        sArray = s.toCharArray();
        len = sArray.length;
        int leftRemove = 0;
        int rightRemove = 0;
        for(int i=0;i<len;i++){
            if(sArray[i] == '('){
                leftRemove++;
            }else if(sArray[i] == ')'){
                if(leftRemove == 0){
                    rightRemove++;
                }
                if(leftRemove > 0){
                    leftRemove--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        dfs(0,0,0,leftRemove, rightRemove, sb);
        return new ArrayList<>(set);
    }

    private void dfs(int index, int leftCount, int rightCount, int leftRemove, int rightRemove, StringBuilder sb){
        if(index == len){
            if(leftRemove == 0 && rightRemove == 0){
                set.add(sb.toString());
            }
            return;
        }
        char ch = sArray[index];
        if(ch == '(' && leftRemove > 0){
            dfs(index+1, leftCount, rightCount, leftRemove-1, rightRemove, sb);
        }
        if(ch == ')' && rightRemove > 0){
            dfs(index+1, leftCount, rightCount, leftRemove, rightRemove-1, sb);
        }
        sb.append(ch);
        if(ch != '(' && ch != ')'){
            dfs(index+1, leftCount, rightCount, leftRemove, rightRemove, sb);
        }else if(ch == '('){
            dfs(index+1, leftCount+1, rightCount, leftRemove, rightRemove, sb);
        }else if(rightCount < leftCount){
            dfs(index+1, leftCount, rightCount+1, leftRemove, rightRemove, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}