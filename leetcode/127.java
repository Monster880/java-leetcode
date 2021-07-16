class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> visited = new HashSet<String>();
        Set<String> words = new HashSet<String>();
        Deque<String> queue = new LinkedList<String>();
        for(int i = 0; i < wordList.size(); ++i) {
            words.add(wordList.get(i));
        }
        queue.add(beginWord);
        visited.add(beginWord);
        int wordLen = beginWord.length();
        int res = 1;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; ++i) {
                String str = queue.poll();
                char[] array = str.toCharArray();
                for(int j = 0; j < array.length; ++j) {
                    char ordChar = array[j];
                    for(char ch = 'a'; ch <= 'z'; ++ch) {
                        if(ch == ordChar) {
                            continue;
                        }
                        array[j] = ch;
                        String newStr = String.valueOf(array);
                        if(words.contains(newStr)) {
                            if(endWord.equals(newStr)) {
                                return res + 1;
                            }
                            if(!visited.contains(newStr)) {
                                visited.add(newStr);
                                queue.add(newStr);
                            }
                        }
                    }
                    array[j] = ordChar;
                }
            }
            res += 1;
        }
        return 0;
    }
}