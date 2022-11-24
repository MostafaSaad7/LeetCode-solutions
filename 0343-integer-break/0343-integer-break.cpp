const int MAX = 60 + 1;
int memory[MAX];

class Solution {
public:
	int productSum(int num) {
		if (num== 1)
			return 1;

		auto &ret = memory[num];
		if (ret != -1)
			return ret;

		ret = num;	// default don't divide 
        // eg :4 >> 2 * 2   >> the max of 2 is 2 if we not divide it but if we divide 
        // the max if 2 >> 1 * 1 so we have to mustn't divide  
		for (int i = 1; i < num; i++)
			ret = max(ret, i * productSum(num - i));

		return ret;
	}

	int integerBreak(int n) {
		// Special case for these 2 numbers: must k >= 2
		if (n == 2 || n == 3)
			return n-1;

		memset(memory, -1, sizeof(memory));
		return productSum(n);
	}
};
