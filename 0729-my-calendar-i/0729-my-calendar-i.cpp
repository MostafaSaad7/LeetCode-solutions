class MyCalendar
{
    map<int, int> m;

public:
    MyCalendar()
    {
    }

    bool book(int start, int end)
    {
        if (m.empty())
        {
            m[start] = end;
            return true;
        }

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