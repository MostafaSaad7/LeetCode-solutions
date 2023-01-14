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
        mp[tokenId] = currentTime;
    }

    void renew(string tokenId, int currentTime)
    {
        if (mp.count(tokenId) && (mp[tokenId] + timeToLive) > currentTime)
        {
            mp[tokenId] = currentTime;
        }
    }

    int countUnexpiredTokens(int currentTime)
    {
        int tokensNumber = 0;
        for (auto i : mp)
        {
            if (i.second + timeToLive > currentTime)
                tokensNumber++;
        }
        return tokensNumber;
    }
};
