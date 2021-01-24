#include<iostream>
#include<vector>
#include<unordered_set>


using namespace std;

//
//class Solution {
//public:
//	vector<bool> dp;
//	bool wordBreak(string s, vector<string>& wordDict) {
//		dp = vector<bool>(s.length()+1, false);
//		unordered_set<string> unSet;
//
//		for (auto s : wordDict) {
//			unSet.insert(s);
//		}
//
//		dp[0] = true;
//		for (int i = 1; i <= s.length(); i++) {
//			for (int j = i - 1; j >= 0 ; j--) {
//				if (dp[j] == false)
//					continue;
//
//				string pword = s.substr(j, i - j);
//				if (unSet.find(pword) != unSet.end()) {
//					dp[i] = true;
//					break;
//				}
//
//			}
//		}
//		return dp[s.length()];
//	}
//};



class Solution {
public:
	vector<char> dp;
	bool wordBreak(string s, vector<string>& wordDict) {
		dp = vector<char>(s.length(), -1);
		unordered_set<string> unSet;

		for (auto s : wordDict) {
			unSet.insert(s);
		}
		return canBrk(0, s, unSet);
	}

	bool canBrk(int start, string& s, unordered_set<string>& unSet) {
		int n = s.length();
		if(n == start) return 1;

		if (dp[start] != -1) return dp[start];

		string str;
		for (int i = start; i < n; i++)
			if (unSet.count(str += s[i]) && canBrk(i + 1, s, unSet)) return dp[start] = 1;
		
		return dp[start] = 0;
	}
};

int main() {

}


