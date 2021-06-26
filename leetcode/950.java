class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        Deque<Integer> q = new LinkedList<>();
        q.push(deck[n-1]);
        for(int i= n-2; i>=0; i--){
            q.addFirst(q.removeLast());
            q.addFirst(deck[i]);
        }
        int[] r = new int[n];
        for(int i=0;i <n;i++){
            r[i] = q.poll();
        }
        return r;
    }
}