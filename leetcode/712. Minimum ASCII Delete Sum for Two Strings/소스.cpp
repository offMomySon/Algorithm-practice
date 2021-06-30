#include<iostream>
#include<vector>
#include<string>
#include<algorithm>

using namespace std;

class Solution {
public:
	vector<vector<int>> dp;
	int cal_end_str(string &s, int i) {
		int sum = 0;

		for (; i < s.length(); i++) {
			sum += int(s[i]);
		}

		return sum;
	}

	int minimumDeleteSum(string s1, string s2) {
		dp = vector<vector<int>>(s1.length()+1, vector<int>(s2.length()+1, -1));

		return cal_minSum(s1, s2, 0, 0);

	}

	int cal_minSum(string &s1, string &s2, int i, int j) {
		if (dp[i][j] != -1)
			return dp[i][j];
		
		int s1_len = s1.length();
		int s2_len = s2.length();

		if (s1_len == i || s2_len == j) {
			if (s1_len == i && s2_len == j) {
				dp[i][j] = 0;
			}
			else if (s1_len == i) {
				dp[i][j] = cal_end_str(s2, j);
			}
			else {
				dp[i][j] = cal_end_str(s1, i);
			}

			return dp[i][j];
		}

		if (s1[i] == s2[j]) {
			dp[i][j] = cal_minSum(s1, s2, i + 1, j + 1);
		}
		else {
			dp[i][j] = min( 
				cal_minSum(s1, s2, i + 1, j) + int(s1[i]),
				cal_minSum(s1, s2, i, j+1) + int(s2[j]) 
			);
		}

		return dp[i][j];
	}
};

int main() {
	Solution* s = new Solution();
	cout << s->minimumDeleteSum("delete", "leet");
}
//https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/