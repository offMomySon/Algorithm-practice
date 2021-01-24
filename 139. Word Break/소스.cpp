#include<iostream>
#include<vector>
#include<unordered_set>


using namespace std;


class Solution {
public:
	vector<bool> dp;
	bool wordBreak(string s, vector<string>& wordDict) {
		dp = vector<bool>(s.length()+1, false);
		unordered_set<string> unSet;

		for (auto s : wordDict) {
			unSet.insert(s);
		}

		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = i - 1; j >= 0 ; j--) {
				if (dp[j] == false)
					continue;

				string pword = s.substr(j, i - j);
				if (unSet.find(pword) != unSet.end()) {
					dp[i] = true;
					break;
				}

			}
		}

		return dp[s.length()];
	}

};

int main() {

}


