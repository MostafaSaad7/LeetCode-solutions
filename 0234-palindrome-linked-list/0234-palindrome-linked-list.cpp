class Solution
{
public:
    bool isPalindrome(ListNode *head)
    {
        deque<ListNode *> d;
        ListNode *temp = head;
        while (temp)
        {
            d.push_back(temp);
            temp = temp->next;
        }

        while (!d.empty())
        {

            if (d.front()->val == d.back()->val)
            {
                if (d.size() > 1)
                {
                    d.pop_back();
                    d.pop_front();
                }
                else
                    d.pop_back();
            }

            else
                return false;
        }
        return true;
    }
};