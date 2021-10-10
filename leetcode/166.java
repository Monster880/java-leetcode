class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = (long) numerator;
        long denominatorLong = (long) denominator;
        if(numeratorLong % denominatorLong == 0){
            return String.valueOf(numeratorLong / denominatorLong);
        }
        StringBuffer sb = new StringBuffer();
        if(numeratorLong < 0 ^ denominatorLong < 0){
            sb.append('-');
        }
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        long integerPart = numeratorLong / denominatorLong;
        sb.append(integerPart);
        sb.append('.');

        StringBuffer fractionPart = new StringBuffer();
        Map<Long, Integer> remainderMap = new HashMap<>();
        long remainder = numeratorLong % denominatorLong;
        int index = 0;
        while(remainder != 0 && !remainderMap.containsKey(remainder)){
            remainderMap.put(remainder, index);
            remainder *= 10;
            fractionPart.append(remainder / denominatorLong);
            remainder %= denominatorLong;
            index++;
        }
        if(remainder != 0){
            int remainderIndex = remainderMap.get(remainder);
            fractionPart.insert(remainderIndex, '(');
            fractionPart.append(')');
        }
        sb.append(fractionPart.toString());
        return sb.toString();
    }
}