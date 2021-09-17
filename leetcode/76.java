class Solution {
    Map<Character, Integer> temp = new HashMap<>();
    Map<Character, Integer> map = new HashMap<>();

    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        for(int i=0; i<tLen; i++){
            char ch = t.charAt(i);
            temp.put(ch, temp.getOrDefault(ch, 0) + 1);
        }
        int left = 0, right = -1;
        int len = Integer.MAX_VALUE, resL = -1, resR = -1;

        while(right < sLen){
            right++;
            if(right < sLen && temp.containsKey(s.charAt(right))){
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            }
            while(check() && left <= right){
                if(right - left + 1 < len){
                    len = right - left + 1;
                    resL = left;
                    resR = left + len;
                }
                if(temp.containsKey(s.charAt(left))){
                    map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                }
                left++;
            }
        }
        return resL == -1 ? "" : s.substring(resL, resR);
    }

    public boolean check(){
        Iterator iterator = temp.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            Character key = (Character) entry.getKey();
            Integer value = (Integer) entry.getValue();
            if(map.getOrDefault(key, 0) < value){
                return false;
            }
        }
        return true;
    }
}