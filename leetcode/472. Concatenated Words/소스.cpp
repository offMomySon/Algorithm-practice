#include<iostream>
#include<vector>
#include<unordered_set>
#include<algorithm>

using namespace std;

class Solution {
public:
	bool static cmp(string a, string b) {
		return a.length() < b.length();
	}

	vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
		vector<string> res;
		sort(words.begin(), words.end(), cmp);

		unordered_set<string> dict;
		for (auto str : words) {
			if (isConcaternatedWord(str, dict) && str.length() > 0)
				res.push_back(str);

			dict.insert(str);
		}
		return res;
	}

	bool isConcaternatedWord(string &str, unordered_set<string>& dict) {
		vector<char> dp(str.size(), -1);
		return canConCate(0, str,dict, dp);
	}

	bool canConCate(int start, string& str, unordered_set<string>& dict, vector<char> &dp) {
		if (str.length() <= start)
			return true;

		if (dp[start] != -1) return dp[start];	

		string temp;
		for (int i = start; i < str.length(); i++) {
			temp += str[i];
			if ((dict.find(temp) != dict.end()) &&
				canConCate(i+1, str, dict, dp))
				return dp[start] = 1;
		}	
		return dp[start] = 0;
	}
};

int main() {
	Solution* s = new Solution();
	vector<string> test({ "" });
	s->findAllConcatenatedWordsInADict(test);

}
