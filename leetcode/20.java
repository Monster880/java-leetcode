class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            switch(c){
                case '(' : case '[' : case '{' : 
                    st.push(c);
                    break;
                case ')':
                    if(st.empty() || st.pop() != '('){
                        return false;
                    }
                    break;
                case ']':
                    if(st.empty() || st.pop() != '['){
                        return false;
                    }
                    break;
                case '}':
                    if(st.empty() || st.pop() != '{'){
                        return false;
                    }
                    break;
            }
        }
        return st.empty();
    }
}