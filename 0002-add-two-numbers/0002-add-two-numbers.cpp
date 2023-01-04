class Solution
{
    int carry = 0;

public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
    {
         
         if (!l1 && !l2 && !carry)
            return NULL;
        
        else if (!l1 && !l2 && carry)
            return new ListNode(carry);

        ListNode *newHead;
        int num1 = 0, num2 = 0;
        if (l1)
            num1 = l1->val;
        if (l2)
            num2 = l2->val;

        int sum = num1 + num2 + carry;
        int res = sum % 10;
        carry = sum / 10;

        newHead = new ListNode(res);
        if (l1 && l2)
            newHead->next = addTwoNumbers(l1->next, l2->next);
        else if (l1)
            newHead->next = addTwoNumbers(l1->next, l2);
        else if (l2)
            newHead->next = addTwoNumbers(l1, l2->next);


        return newHead;
    }
};