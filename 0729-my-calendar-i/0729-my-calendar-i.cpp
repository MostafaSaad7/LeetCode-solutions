class MyCalendar
{
    map<int, int> m;

public:
    MyCalendar()
    {
    }

    bool book(int start, int end)
    {
        

        auto it = m.lower_bound(start);
        

        if (it != m.end())
        {
            if (it->first < end)
                return false;
        }

        if (it != m.begin())
        {
            it--;
            if (it->second > start)
                return false;
        }

        m[start] = end;
        return true;
    }
};