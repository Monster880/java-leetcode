class Solution {
    public double average(int[] salary) {
        double max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        double sum = 0;
        for(int cost : salary){
            sum += cost;
            max = Math.max(cost, max);
            min = Math.min(cost, min);
        }
        return (sum - max - min) / (salary.length - 2);
    }
}