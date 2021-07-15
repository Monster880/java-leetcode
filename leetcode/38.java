class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, candidates, target, new ArrayList<Integer>(), 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] candidates, int target, ArrayList<Integer> temp, int index){
        if(index == candidates.length){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        backtrack(res, candidates, target, temp, index+1);
        if(target >= candidates[index]){
            temp.add(candidates[index]);
            backtrack(res, candidates, target-candidates[index], temp, index);
            temp.remove(temp.size()-1);
        }
    }
}