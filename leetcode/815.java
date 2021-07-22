class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        int n = routes.length;
        boolean[][] edge = new boolean[n][n];
        Map<Integer, List<Integer>> ans = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            for (int site : routes[i]) {
                List<Integer> list = ans.getOrDefault(site, new ArrayList<Integer>());
                for (int j : list) {
                    edge[i][j] = edge[j][i] = true;
                }
                list.add(i);
                ans.put(site, list);
            }
        }

        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int bus : ans.getOrDefault(source, new ArrayList<Integer>())) {
            dist[bus] = 1;
            queue.offer(bus);
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int y = 0; y < n; y++) {
                if (edge[x][y] && dist[y] == -1) {
                    dist[y] = dist[x] + 1;
                    queue.offer(y);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int bus : ans.getOrDefault(target, new ArrayList<Integer>())) {
            if (dist[bus] != -1) {
                res = Math.min(res, dist[bus]);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}