class Solution {
    int[][] booksRef;
    Integer[] cache;
    int shelfWidth;

    public int minHeightShelves(int[][] books, int shelfWidth) {
        this.shelfWidth = shelfWidth;
        booksRef = books;
        cache = new Integer[books.length];

        return dfs(0);

    }

    private int dfs(int i) {
        if (i == booksRef.length)
            return 0;
        if (cache[i] != null)
            return cache[i];


        int max_Height = 0;
        int currentWidth = shelfWidth;
        cache[i] = Integer.MAX_VALUE;


        for (int j = i; j < booksRef.length; j++) {
            int width = booksRef[j][0];
            int height = booksRef[j][1];
            if (currentWidth < width)
                break;
            currentWidth -= width;
            max_Height = Math.max(height, max_Height);
            cache[i] = Math.min(cache[i], dfs(j + 1) + max_Height);
        }


        return cache[i];
    }
}