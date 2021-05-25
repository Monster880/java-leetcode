import java.util.*;

class Solution {
    private List<Integer> topsort(List<Integer> all, int[] ind, Set<Integer>[] oud){
        Queue<Integer> q = new LinkedList<>();
        for(int x : all){
            if(ind[x] == 0){
                q.add(x);
            }
        }
        List<Integer> r = new ArrayList<>();
        while(!q.isEmpty()){
            int x = q.poll();
            r.add(x);
            for(int y : oud[x]){
                if(--ind[y] == 0){
                    q.add(y);
                }
            }
            oud[x].clear();
        }
        return r;
    }

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int[] id = new int[n];
        Arrays.fill(id, -1);
        m = 0;
        for(int i=0;i<n;i++){
            if(group[i] >= 0){
                if(id[group[i]] < 0){
                    id[group[i]] = m++;
                }
                group[i] = id[group[i]];
            }
        }
        for(int i=0;i<n;i++){
            if(group[i] < 0){
                group[i] = m++;
            }
        }
        Set<Integer>[] oud = new Set[n];
        for(int i=0;i<n;i++){
            oud[i] = new HashSet<>();
        }
        List<Integer>[] items = new List[n];
        List<Integer> all = new ArrayList<Integer>();
        for(int i=0; i<m;i++){
            items[i] = new ArrayList<>();
            all.add(i);
        }
        int[] ind = new int[n];
        for(int i=0;i<n;i++){
            items[group[i]].add(i);
            for(int x : beforeItems.get(i)){
                if(group[x] != group[i] && oud[group[x]].add(group[i])){
                    ind[group[i]]++;
                }
            }
        }
        List<Integer> r = topsort(all, ind, oud);
        if(r.size() < m){
            return new int[0];
        }
        List<Integer> ans = new ArrayList<>();
        for(int g : r){
            for(int x : items[g]){
                for(int y : beforeItems.get(x)){
                    if(group[y] == g){
                        oud[y].add(x);
                        ind[x]++;
                    }
                }
            }
            List<Integer> temp = topsort(items[g], ind, oud);
            if(temp.size() < items[g].size()){
                return new int[0];
            }
            ans.addAll(temp);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}