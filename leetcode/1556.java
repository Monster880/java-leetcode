class Solution {
    public String thousandSeparator(int n) {
        int count = 0;
        StringBuffer sb = new StringBuffer();
        do{
            int cur = n % 10;
            n /= 10;
            sb.append(cur);
            count++;
            if(count % 3 == 0 && n != 0){
                sb.append(".");
            }
        }while(n != 0);
        sb.reverse();
        return sb.toString();
    }
}