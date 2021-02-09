#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

class Solution {
public:
	vector<vector<int>> dp;

	bool stoneGame(vector<int>& piles) {
		dp = vector<vector<int>>(piles.size() + 1, vector<int>(piles.size() + 1,-1));


		if (stoneGameHelper(piles, 0, piles.size()-1, true) > 0)
			return true;
		return false;
	}

	int stoneGameHelper(vector<int>& piles, int start, int end, bool turn) {

		if (start > end)
			return 0;
		if (dp[start][end] != -1)
			return dp[start][end];

		if (turn) {
			int front = stoneGameHelper(piles, start + 1, end, false) + piles[start];
			int back = stoneGameHelper(piles, start, end-1, false) + piles[end];
			return dp[start][end] = max(front, back);
		}

		int front = stoneGameHelper(piles, start + 1, end, true) - piles[start];
		int back = stoneGameHelper(piles, start, end - 1, true) - piles[end];
		return dp[start][end] = min(front, back);

	}
};