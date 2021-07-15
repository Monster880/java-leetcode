class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        backtrack(res, candidates, combine, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] candidates, List<Integer> combine, int target, int index){
        if(index == candidates.length){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(combine));
            return;
        }
        backtrack(res, candidates, combine, target, index+1);
        if(target - candidates[index] >= 0){
            combine.add(candidates[index]);
            backtrack(res, candidates, combine, target-candidates[index], index);
            combine.remove(combine.size()-1);
        }
    }
}