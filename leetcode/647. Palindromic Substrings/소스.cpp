#include<iostream>
#include<vector>

using namespace std;

// dp[x][y] = if dp[x+1][y-1] == true
//               str[x] == str[y]
//               or false

class Solution {
public:
	int countSubstrings(string s) {
		if (s.length() == 0) {
			return 0;
		}
		vector<vector<bool>> dp(s.length(), vector<bool>(s.length(), false));

		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = true;
		}

		calculateDp(dp, s);

		return countPalindromic(dp, s.length());
	}
private:
	void calculateDp(vector<vector<bool>>& dp, string &s) {
		for (int i = s.length(); i >= 0; i--) {
			for (int j = i+1; j < s.length(); j++) {
				if (s.at(j) != s.at(i)) {
					continue;
				}

				if (j == i + 1) {
					dp[i][j] = true;
					continue;
				}

				if (dp[i + 1][j - 1] == true) {
					dp[i][j] = true;
				}
			}
		}
	}

	int countPalindromic(vector<vector<bool>>& dp, int strlen) {
		int count = 0;
		for (int i = strlen; i >= 0; i--) {
			for (int j = i; j < strlen; j++) {
				if (dp[i][j] == true) {
					count++;
				}
			}
		}
		return count;
	}
};

int main() {

}