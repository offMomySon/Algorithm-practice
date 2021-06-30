#include<iostream>
#include<vector>
#include<unordered_set>
#include<unordered_map>

using namespace std;


class Solution {
public:
	unordered_map<string, vector<string>> word_map;

	vector<string> wordBreak(string s, vector<string>& wordDict) {
		unordered_set<string> dict;
		for (auto str : wordDict) {
			dict.insert(str);
		}

		return wordHelper(s, dict);
	}

	vector<string> wordHelper(string& s, unordered_set<string>& dict) {
		vector<string> res;
		if (s.length() <= 0)
			return res;

		if (word_map.find(s) != word_map.end()) {
			return word_map[s];
		}

		if (dict.find(s) != dict.end()) res.push_back(s);

		for (int i = 1; i < s.length() ; i++) {
			string word = s.substr(0, i);
			if (dict.find(word) != dict.end()) {
				string left_word = s.substr(i);
				vector<string> prevRes = combine(word, wordHelper(left_word, dict));
				res.insert(res.end(), prevRes.begin(), prevRes.end());
			}
		}

		word_map[s] = res;
		return res;
	}

	vector<string> combine(string& str, vector<string> prv) {
		for (int i = 0; i < prv.size(); i++) {
			prv[i] = str + " " + prv[i];
		}
		return prv;
	}
};


int main() {

}