class Solution
{
public:
    bool isPalindrome(ListNode *head)
    {
        ListNode *fast = head;
        ListNode *slow = head;

        // middle
        while (fast && fast->next)
        {
            fast = fast->next->next;
            slow = slow->next;
        }

        ListNode *prev = nullptr;
        while (slow)
        {
            ListNode *temp = slow->next;
            slow->next = prev;
            prev = slow;
            slow = temp;
        }
        ListNode *left = head;
        ListNode *right = prev;
        while (right)
        {
            if (left->val == right->val)
            {
                left = left->next;
                right = right->next;
            }
            else
                return false;
        }

        return true;
    }
};