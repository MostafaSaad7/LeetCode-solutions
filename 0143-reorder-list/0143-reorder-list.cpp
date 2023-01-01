class Solution
{
public:
    ListNode *middleNode(ListNode *head)
    {
        ListNode *slow = head;
        ListNode *fast = head->next;
        while (fast && fast->next)
        {
            fast = fast->next->next;
            slow = slow->next;
        }

        return slow;
    }
    ListNode *reverseList(ListNode *secondHalf)
    {
        ListNode *current = secondHalf;
        ListNode *past = nullptr;
        while (current)
        {
            ListNode *next = current->next;
            current->next = past;
            past = current;
            current = next;
        }
        return past;
    }
    void reorderList(ListNode *head)
    {
        ListNode *middle = middleNode(head);
        ListNode *secondHead = reverseList(middle);
        ListNode *firstHead = head;
        while (secondHead && firstHead)
        {
            ListNode *next1 = firstHead->next;
            ListNode *next2 = secondHead->next;
            firstHead->next = secondHead;
            secondHead->next = next1;
            firstHead = next1;
            secondHead = next2;
        }
    }
};