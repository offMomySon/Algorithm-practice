#include<iostream>
#include<vector>

using namespace std;


class Solution {
public:
	vector<int> findAnagrams(string s, string p) {
		vector<int> slidingWindow(26, 0), pattern(26, 0), res;
		if (s.size() < p.size())
			return res;

		for (int i = 0; i < p.size(); i++) {
			++slidingWindow[s[i] - 'a'];
			++pattern[p[i] - 'a'];
		}

		if (slidingWindow == pattern) {
			res.push_back(0);
		}

		for (int i = p.size(); i < s.size(); i++) {
			++slidingWindow[s[i] - 'a'];

			--slidingWindow[s[i - p.size()] - 'a'];

			if (slidingWindow == pattern) {
				res.push_back(i - p.size() + 1);
			}
		}

		return res;
	}
};

int main() {
	Solution* s = new Solution();

	vector<int> v = s->findAnagrams("cbaebabacd", "abc");

	for (auto it = v.begin(); it != v.end(); it++) {
		cout << *it << endl;
	}

}