class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int index = 0;
        while(index < n){
            int gasSum = 0, costSum = 0;
            int count = 0;
            while(count < n){
                int j = (index + count) % n;
                gasSum += gas[j];
                costSum += cost[j];
                if(costSum > gasSum){
                    break;
                }
                count++;
            }
            if(count == n){
                return index;
            }else{
                index = index + count + 1;
            }
        }
        return -1;
    }
}