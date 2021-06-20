class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        for(int i=0, j=1; i<target.length; j++){
            ans.add("Push");
            if(j < target[i]){
                ans.add("Pop");
            }else{
                i++;
            }
        }
        return ans;
    }
}