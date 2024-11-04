class Solution {
    public String compressedString(String word) {
        char currentchar = word.charAt(0);
        int counter = 1;
        int index = 1;
        StringBuilder res = new StringBuilder();
        while (index < word.length()) {
            if (word.charAt(index) == currentchar) {
                counter++;
                if (counter == 9) {
                    res.append(counter).append(currentchar);
                    counter = 0;
                }
            } else {
                if (counter != 0)
                    res.append(counter).append(currentchar);
                currentchar = word.charAt(index);
                counter = 1;
            }
            index++;
        }
        if (counter != 0)
        res.append(counter).append(currentchar);
        return res.toString();

    }

    public static void main(String[] args) {
        new Solution().compressedString("aaaaaaaaay");
    }
}

/*
}
*
* aaaaaaaaaaaaaabb
*
* */