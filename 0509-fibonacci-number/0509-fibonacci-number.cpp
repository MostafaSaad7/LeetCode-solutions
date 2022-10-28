class Solution {
public:
    int fib(int n) {
        
        int p1 = 0 ;
        int p2 = 1 ;
        if(n==0 )
            return p1;
        for(int i = 2 ; i <= n ; i++)
        {
            int temp = p2 ;
            
            p2 = p1 + p2 ;
            p1 = temp ;
        }
        
        return p2;

    }
};