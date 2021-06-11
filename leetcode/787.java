// 深度遍历解法超时
public class Solution {

    private int[][] graph;
    private boolean[] visited;
    private int res = Integer.MAX_VALUE;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        K = Math.min(K, n - 2);

        this.graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }

        this.visited = new boolean[n];
        // 开始深度优先遍历，注意：这里传 K + 1，这是因为 K 次经停，总共 K + 1 个站
        dfs(src, dst, K + 1, 0);

        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }


    /**
     * 从 src 出发，到 dst 为止，最多经过 k 站（这里 k 包括 src）
     *
     * @param src  起点站
     * @param dst  终点站
     * @param k    经过的站点数限制
     * @param cost 已经花费的价格
     */
    private void dfs(int src, int dst, int k, int cost) {
        if (src == dst) {
            res = cost;
            return;
        }

        if (k == 0) {
            return;
        }

        for (int i = 0; i < graph[src].length; i++) {
            if (graph[src][i] > 0) {
                if (visited[i]) {
                    continue;
                }

                // 剪枝：跳过可能产生较高费用的路径，从而选出最少价格
                if (cost + graph[src][i] > res) {
                    continue;
                }

                visited[i] = true;
                dfs(i, dst, k - 1, cost + graph[src][i]);
                visited[i] = false;
            }
        }
    }
}

// Dijkstra算法超时
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // 使用邻接矩阵表示有向图，0 表示不连通
        int[][] graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        // 向集合添加一个记录（起点, 费用, 站数限制）的数组，K + 1 表示可以走过站点的个数
        minHeap.offer(new int[]{src, 0, K + 1});

        while (!minHeap.isEmpty()) {
            int[] front = minHeap.poll();
            int v = front[0];
            int price = front[1];
            int k = front[2];

            if (v == dst) {
                return price;
            }

            // 如果还可以中转一个站
            if (k > 0) {
                for (int i = 0; i < n; i++) {
                    // 并且存在一条有向边
                    if (graph[v][i] > 0 ) {
                        // 优先队列中存入：有向边指向的顶点 i、从起点 src 到 i 的总路径长度、还有多少站可以中转
                        minHeap.offer(new int[]{i, price + graph[v][i]  , k - 1});
                    }
                }
            }
        }
        return -1;
    }
}

// Floyd算法succeed
import java.util.Arrays;

public class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int maxPrice = 1000000000;

        int[][] dp = new int[n][K + 1];
        // 初始化 1：由于找最短路径，因此初始化的时候赋值成为一个不可能的较大的值
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], maxPrice);
        }
        // 自己到自己，不管经过几个顶点，最短路径都是 0
        for (int i = 0; i <= K; i++) {
            dp[src][i] = 0;
        }

        // 第 1 轮松弛操作，只需要对从 src 出发的边进行松弛操作
        for (int[] flight : flights) {
            if (flight[0] == src) {
                dp[flight[1]][0] = flight[2];
            }
        }

        // 第 2 轮到第 K + 1 轮松弛操作，最后一轮松弛操作是为了检测是否可达
        for (int i = 1; i <= K; i++) {
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                // 每一次松弛操作的结果是互相独立的，因此只有在上一轮（第 i - 1 轮）得到单源最短路径的顶点，才需要执行松弛操作
                if (dp[from][i - 1] != maxPrice) {
                    dp[to][i] = Math.min(dp[from][i - 1] + flight[2], dp[to][i]);
                }
            }
        }

        // 如果不可达，返回 -1
        if (dp[dst][K] == maxPrice) {
            return -1;
        }
        return dp[dst][K];
    }
}