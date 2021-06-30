#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

class Solution {
public:
	vector<int> dp;

	int minCostClimbingStairs(vector<int>& cost) {
		dp = vector<int>(cost.size() + 1, -1);

		int res = minHelper(cost, 0);
		res = min(res, minHelper(cost, 1));
		
		return res;
	}

	int minHelper(vector<int> &cost, int idx) {
		if (cost.size() <= idx)
			return 0;

		if (dp[idx] != -1)
			return dp[idx];

		
		int res = minHelper(cost, idx + 1);
		res = min(res, minHelper(cost, idx + 2));

		dp[idx] = res + cost[idx];
		return dp[idx];
	}
};

int main() {

}