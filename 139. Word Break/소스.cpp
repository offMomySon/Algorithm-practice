#include<iostream>
#include<vector>
#include<unordered_set>

using namespace std;

class Solution {
public:
	vector<char> dp;
	bool wordBreak(string s, vector<string>& wordDict) {
		unordered_set<string> wordSet;
		dp = vector<char>(s.size(), -1);
		for (auto str : wordDict) {
			wordSet.insert(str);
		}

		return canBreak(0, s, wordSet);
	}

	bool canBreak(int start, string& s, unordered_set<string> wordSet) {
		if (s.length() == start)
			return 1;

		if (dp[start] != -1) return dp[start];

		string tempStr;
		for (int i = start; i < s.length(); i++) {
			tempStr += s[i];
			if (wordSet.count(tempStr) && canBreak(i + 1, s, wordSet))
				return dp[start] = 1;
		}

		return dp[start] = 0;
	}

};


int main() {

}

//https://leetcode.com/problems/word-break/discuss/43886/Evolve-from-brute-force-to-optimal-a-review-of-all-solutions
