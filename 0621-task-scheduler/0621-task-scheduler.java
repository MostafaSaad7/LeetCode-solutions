class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        int mostFreqCharactersCount = 0;
        int maxFreq = 0;
        for (var character : tasks) {
            freq[character - 'A']++;
            if (maxFreq == freq[character - 'A']) {
                mostFreqCharactersCount++;
            } else if (maxFreq < freq[character - 'A']) {
                maxFreq = freq[character - 'A'];
                mostFreqCharactersCount = 1;
            }
        }

        int partCount = maxFreq - 1; // A -- A -- A  --> 3-1 --> have 2 parts
        int partLen = (n - (mostFreqCharactersCount - 1));  // having 3A and 3B n = 2  ---> AB - AB - AB  -- >  (n=2) -[(mostFreq=2) -1]
        int emptySlots = partCount * partLen;
        int availableTasksToBeUsedWithMostFreq = tasks.length - maxFreq * mostFreqCharactersCount;
        int idlesNum = Math.max(0, emptySlots - availableTasksToBeUsedWithMostFreq);

        return tasks.length + idlesNum;

    }
}