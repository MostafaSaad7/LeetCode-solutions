class Node
{
public:
    int data;
    Node *next;
    Node *prev;
    Node(int data)
    {
        this->data = data;
        next = NULL;
        prev = NULL;
    }
};

class MyCircularQueue
{
private:
    Node *head;
    Node *tail;
    int size;

public:
    MyCircularQueue(int k)
    {
        size = k;
        head = new Node(0);
        tail = new Node(0);
        head->next = tail;
        tail->prev = head;
    }

    bool enQueue(int value)
    {
        if (isFull())
            return false;
        Node *temp = new Node(value);
        temp->next = tail;
        temp->prev = tail->prev;
        tail->prev->next = temp;
        tail->prev = temp;
        size--;
        return true;
    }

    bool deQueue()
    {
        if (isEmpty())
            return false;
        Node *temp = head->next;
        head->next = head->next->next;
        head->next->prev = head;
        delete temp;
        size++;
        return true;
    }

    int Front()
    {
        if (isEmpty())
            return -1;
        return head->next->data;
    }

    int Rear()
    {
        if (isEmpty())
            return -1;
        return tail->prev->data;
    }

    bool isEmpty()
    {
        if (head->next == tail)
            return true;
        return false;
    }

    bool isFull()
    {
        if (size == 0)
            return true;
        return false;
    }
};
