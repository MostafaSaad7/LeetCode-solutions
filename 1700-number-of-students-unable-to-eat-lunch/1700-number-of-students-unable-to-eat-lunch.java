import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int sandwichPointer = 0;
        int studentsThatAte1 = 0;
        int studentsThatAte0 = 0;

        for (int student : students) {
            if (student == 1)
                studentsThatAte1++;
            else
                studentsThatAte0++;

        }
        while (sandwichPointer < sandwiches.length) {

            if (sandwiches[sandwichPointer] == 1 && studentsThatAte1 > 0) {
                studentsThatAte1--;
            } else if ((sandwiches[sandwichPointer] == 0 && studentsThatAte0 > 0)) {
                studentsThatAte0--;
            } else {
                return studentsThatAte0 + studentsThatAte1;
            }

            sandwichPointer++;
        }

        return 0;
    }
}