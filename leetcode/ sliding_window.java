int cal(String s, int k){
    int[] nums = new int[26];
    int r = 0;
    for(int i=0, j=0, x=0;i<s.length;i++){
        for(;x < k && j<s.length;j++){
            if(++nums[(int)(s.charAt(j) - 'a')] == 1){
                ++x;
            }
        }
        if(x < k) break;
        r += s.length - j + 1;
        if(--nums[(int)(s.charAt(i) - 'a')] == 0){
            x--;
        }
    }
    return r;
}

main call: cal(s,k) - cal(s,k+1);