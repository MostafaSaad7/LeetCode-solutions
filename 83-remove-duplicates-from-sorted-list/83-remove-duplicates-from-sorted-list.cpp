/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        
        if(!head)
            return head;
        ListNode * curr= head;
        ListNode * it=curr->next;
        bool dup =false;
        while(curr->next)
        {
         if(it &&curr->val == it->val)
         {
             it = it->next;
            dup =true;
         }
             else
            {
                 if(dup)
                deleteNodes(curr->next ,it);
                 dup =false;
                curr->next=it;
                    if(it){   
                curr=it;
                it=curr->next;}
            }
        }

        return head;
        
    }
    
    void deleteNodes(ListNode* start , ListNode* end)
    {
        if(!start)
            return;
        ListNode * temp = nullptr ;
        while(start!=end)
        {
            temp= start;
            start=start->next;
            delete temp;
        }
    }
        
};