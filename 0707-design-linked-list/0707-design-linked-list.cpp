class Node
{
public:
    int val;
    Node *next;
    Node *prev;

    Node(int val, Node *next, Node *prev) : val(val), next(next), prev(prev)
    {
    }
    Node(int val) : val(val), next(nullptr), prev(nullptr)
    {
    }
};

class MyLinkedList
{
private:
    Node *head;
    Node *tail;
    int count;

public:
    MyLinkedList() : count(0), head(nullptr), tail(nullptr)
    {
    }

    int get(int index)
    {
        cout << "count " << count << endl;
        if (index < 0 || index >= count)
            return -1;
        Node *pointer = head;
        for (int i = 0; i < index; i++)
        {
            pointer = pointer->next;
        }

        return pointer->val;
    }

    void addAtHead(int val)
    {
        Node *newNode = new Node(val);
        if (head == nullptr)
        {
            head = newNode;
            tail = newNode;
            count++;
            return;
        }
        newNode->next = head;
        head->prev = newNode;
        head = newNode;
        count++;
    }

    void addAtTail(int val)
    {
        Node *newNode = new Node(val);
        if (tail == nullptr)
        {
            head = newNode;
            tail = newNode;
            count++;
            return;
        }

        newNode->prev = tail;
        tail->next = newNode;
        tail = newNode;
        count++;
    }

    void addAtIndex(int index, int val)
    {
        if (index < 0 || index > count)
            return;
        if (index == 0)
        {
            addAtHead(val);
            return;
        }
        if (index == count)
        {
            addAtTail(val);
            return;
        }
        Node *pointer = head;
        while (index--)
        {
            pointer = pointer->next;
        }
        Node *newNode = new Node(val);
        newNode->next = pointer;
        newNode->prev = pointer->prev;
        pointer->prev->next = newNode;
        pointer->prev = newNode;
        count++;
    }

    void deleteAtIndex(int index)
    {
        if (index < 0 || index >= count)
            return;
        Node *pointer = head;
        while (index--)
        {
            pointer = pointer->next;
        }
        if (pointer->prev == nullptr)
        {
            head = pointer->next;
            if (head)
                head->prev = nullptr;
            delete pointer;
            count--;
            return;
        }
        if (pointer->next == nullptr)
        {
            tail = pointer->prev;
            if (tail)
                tail->next = nullptr;
            delete pointer;
            count--;
            return;
        }
        pointer->prev->next = pointer->next;
        pointer->next->prev = pointer->prev;
        delete pointer;
        count--;
    }

    void print()
    {
        Node *pointer = head;
        while (pointer)
        {
            cout << pointer->val << " ";
            pointer = pointer->next;
        }
        cout << endl;
    }

    ~MyLinkedList()
    {
        Node *pointer = head;
        while (pointer)
        {
            Node *temp = pointer;
            pointer = pointer->next;
            delete temp;
        }

        head = nullptr;
        tail = nullptr;
    }
};