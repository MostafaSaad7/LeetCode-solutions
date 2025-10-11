class Solution {
    private Map<String, Integer> memo;
    
    public int minHeightShelves(int[][] books, int shelfWidth) {
        memo = new HashMap<>();
        // Start with a "fresh shelf" - full width available, height 0
        return helper(0, shelfWidth, 0, books, shelfWidth);
    }
    
    private int helper(int index, int remainingWidth, int currentMaxHeight, 
                       int[][] books, int shelfWidth) {
        // Base case: placed all books
        if (index >= books.length) {
            return currentMaxHeight; // add the last shelf's height
        }
        
        // Create memo key
        String key = index + "," + remainingWidth + "," + currentMaxHeight;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int bookWidth = books[index][0];
        int bookHeight = books[index][1];
        int minHeight = Integer.MAX_VALUE;
        
        // Option 1: Try to add book to current shelf
        if (bookWidth <= remainingWidth) {
            int newMaxHeight = Math.max(currentMaxHeight, bookHeight);
            int result = helper(index + 1, 
                               remainingWidth - bookWidth, 
                               newMaxHeight, 
                               books, 
                               shelfWidth);
            minHeight = Math.min(minHeight, result);
        }
        
        // Option 2: Start a new shelf with this book
        // First, "close" the current shelf by adding its height
        int result = currentMaxHeight + helper(index + 1, 
                                               shelfWidth - bookWidth, 
                                               bookHeight, 
                                               books, 
                                               shelfWidth);
        minHeight = Math.min(minHeight, result);
        
        memo.put(key, minHeight);
        return minHeight;
    }
}