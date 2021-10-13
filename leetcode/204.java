class Solution {
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int res = 0;
        for(int i=2; i < n; i++){
            if(isPrime[i] == 1){
                res++;
                if((long)i*i < n){
                    for(int j=i*i; j<n; j+=i){
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return res;
    }
}