class Solution
{
public:
    Node *copyRandomList(Node *head)
    {
        unordered_map<Node *, Node *> nodesMap;
        Node *current = head;
        if (current == nullptr)
            return current;
        while (current != nullptr)
        {
            nodesMap[current] = new Node(current->val);
            current = current->next;
        }
        current = head;
        while (current != nullptr)
        {
            nodesMap[current]->next = nodesMap[current->next];
            nodesMap[current]->random = nodesMap[current->random];
            current = current->next;
        }

        return nodesMap[head];
    }
};