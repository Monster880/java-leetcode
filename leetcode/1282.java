import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class Solution {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int len = groupSizes.length;
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) {
            return res;
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(len, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < len; i++) {
            minHeap.add(new int[]{groupSizes[i], i});
        }

        while (!minHeap.isEmpty()) {
            int curSize = minHeap.peek()[0];
            List<Integer> current = new ArrayList<>();
            for (int i = 0; i < curSize; i++) {
                current.add(Objects.requireNonNull(minHeap.poll())[1]);
            }
            res.add(current);
        }
        return res;
    }
}