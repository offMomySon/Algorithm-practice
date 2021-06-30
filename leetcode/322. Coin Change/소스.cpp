#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

//
//class Solution {
//public:
//	vector<long> dp;
//
//	static bool cmp(int a, int b) {
//		return a < b;
//	}
//
//	int coinChange(vector<int>& coins, int amount) {
//		dp = vector<long>(amount + 1, INT_MAX);
//		dp[0] = 0;
//		sort(coins.begin(), coins.end(), cmp);
//
//		for (int i = 1; i <= amount; i++) {
//			for (auto coin : coins) {
//				if (i >= coin) {
//
//					dp[i] = min(dp[i], dp[i - coin] + 1);
//				}
//			}
//		}
//
//		return dp[amount] > amount ? -1 : dp[amount];
//	}
//};


class Solution {
public:
	vector<long> dp;
	int MaxNum;

	static bool cmp(int a, int b) {
		return a < b;
	}

	int coinChange(vector<int>& coins, int amount) {
		dp = vector<long>(amount + 1, amount+1);
		dp[0] = 0;
		MaxNum = amount + 1;
		sort(coins.begin(), coins.end(), cmp);


		return change(coins, amount);
	}

	int change(vector<int>& coins, int amount) {
		if (amount < 0)
			return -1;
		if (amount == 0)
			return 0;

		if (dp[amount] != MaxNum)
			return dp[amount];

		int num = MaxNum;
		
		for (auto coin : coins) {
			int res = change(coins, amount - coin);
			if (res >= 0 )
				num = min(num, res + 1);
		}

		dp[amount] = (num == MaxNum )? -1 : num;
		return dp[amount];
	}
};


int main() {
	Solution* s = new Solution();
	vector<int> v({ 1,2,5 });
	cout << s->coinChange(v,11);
}