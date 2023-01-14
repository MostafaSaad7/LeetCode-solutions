class AuthenticationManager
{
private:
    // tokenId --> current time
    unordered_map<string, int> mp;
    int timeToLive;

public:
    AuthenticationManager(int timeToLive) : timeToLive(timeToLive)
    {
    }

    void generate(string tokenId, int currentTime)
    {
        mp[tokenId] = currentTime + timeToLive;
    }

    void renew(string tokenId, int currentTime)
    {
        if (mp.count(tokenId) && mp[tokenId] > currentTime)
        {
            mp[tokenId] = currentTime + timeToLive;
        }
    }

    int countUnexpiredTokens(int currentTime)
    {
        int tokensNumber = 0;
        for (auto i : mp)
        {
            if (i.second > currentTime)
                tokensNumber++;
        }
        return tokensNumber;
    }
};