#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class Solution {
public:
	int maxSubArray(vector<int>& nums) {
		

		vector<int> dp = vector<int>(nums.size(), 0);
		dp[0] = nums[0];
		int maxNum = dp[0];

		for (int i = 1; i < nums.size(); i++) {
			dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
			maxNum = max(maxNum, dp[i]);
		}

		return maxNum;
	}
};