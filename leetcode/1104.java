class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int layer = 1;
        for(; layer <= label; layer <<= 1);
        LinkedList<Integer> ans = new LinkedList<>();
        for(;layer >= 2; layer >>= 1){
            ans.push(label);
            label = (layer - 1 + (layer >> 1) - label) >> 1;
        }
        return ans;
    }
}