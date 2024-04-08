import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int sandwichPointer = 0;
        int studentsThatAte = 0;
        int sawBefore = 0;
        Deque<Integer> studentDeque = new ArrayDeque<>();
        for (int i = 0; i < students.length; i++) {
            studentDeque.addLast(i);
        }
        while (!studentDeque.isEmpty() && sandwichPointer < sandwiches.length && sawBefore<=studentDeque.size()) {

            if (sandwiches[sandwichPointer] == students[studentDeque.getFirst()]) {
                sandwichPointer++;
                studentsThatAte++;
                sawBefore=0;
                studentDeque.removeFirst();
            } else {
                studentDeque.addLast(studentDeque.removeFirst());
                sawBefore++;
            }

        }

        return students.length - studentsThatAte;
    }
}