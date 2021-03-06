class Solution {
    public int myAtoi(String str) {
        Automation automation = new Automation();
        int length = str.length();
        for(int i=0; i<length; i++){
            automation.get(str.charAt(i));
        }
        return (int)(automation.sign * automation.res); 
    }
}

class Automation{
    public int sign = 1;
    public long res = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>(){{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c){
        state = table.get(state)[get_col(c)];
        if("in_number".equals(state)){
            res = res * 10 + c - '0';
            res = sign == 1 ? Math.min(res, (long)Integer.MAX_VALUE) : Math.min(res, -(long)Integer.MIN_VALUE);
        }else if("signed".equals(state)){
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c){
        if(c == ' '){
            return 0;
        }
        if(c == '+' || c == '-'){
            return 1;
        }
        if(Character.isDigit(c)){
            return 2;
        }
        return 3;
    }
}