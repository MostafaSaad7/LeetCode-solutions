import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            queue.add(i);
        }
        Arrays.sort(deck);
        int[] res = new int[deck.length];
        for (var val : deck) {
            int idx = queue.poll();
            res[idx] = val;
            if (!queue.isEmpty()) queue.add(queue.poll());
        }

        return res;
    }
}