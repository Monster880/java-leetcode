class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> res = new HashSet<String>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                dfs(board, trie, i, j, res);
            }
        }
        return new ArrayList<String>(res);
    }

    public void dfs(char[][] board, Trie node, int i, int j, Set<String> res) {
        if (!node.children.containsKey(board[i][j])) {
            return;
        }
        char ch = board[i][j];
        node = node.children.get(ch);
        if (!"".equals(node.word)) {
            res.add(node.word);
        }
        board[i][j] = '#';
        for (int[] dir : dirs) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                dfs(board, node, newi, newj, res);
            }
        }
        board[i][j] = ch;
    }
}

class Trie {
    String word;
    Map<Character, Trie> children;
    public Trie() {
        word = "";
        children = new HashMap<Character, Trie>();
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new Trie());
            }
            node = node.children.get(ch);
        }
        node.word = word;
    }
}