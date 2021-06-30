#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
	int numTrees(int n) {
		vector<int> dp(n+1, 0);

		dp[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			dp[i] = 2 * dp[i - 1];

			for (int j = 1; j <= i - 2; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}

		return dp[n];
	}
};

int main() {
	Solu
}