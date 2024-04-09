class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int reqTime = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k)
                reqTime += Math.min(tickets[k], tickets[i]);
            else
                reqTime += Math.min(tickets[k] - 1, tickets[i]);
        }
        return reqTime;
    }
}