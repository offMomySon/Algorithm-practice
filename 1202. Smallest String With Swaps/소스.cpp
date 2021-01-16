#include<iostream>
#include<vector>
#include<set>
#include<unordered_map>
#include<algorithm>

using namespace std;

bool cmp(char a, char b) {
	return a < b;
}

class Solution {
public:
	vector<int> parent;

	string smallestStringWithSwaps(string s, vector<vector<int>>& pairs) {
		
		parent.assign(s.size(), -1);
		vector<vector<int>> mem(s.size());

		for (auto it = pairs.begin(); pairs.end() != it; it++) {
			merge((*it)[0], (*it)[1]);
		}
		
		for (auto i = 0; i < s.size(); i++) {
			mem[find(i)].push_back(i);
		}

		for (auto ids : mem) {
			string str = "";
			for (auto id : ids) {
				str += s[id];
			}

			sort(begin(str), end(str), cmp);

			for (auto i = 0; i < ids.size(); i++) {
				s[ids[i]] = str[i];
			}
		}


		

		return s;
	}

	//bool cmp(char a, char b) {
	//	return a > b;
	//}

	int find(int n) {
		if (parent[n] == -1)
			return n;

		parent[n] = find(parent[n]);
		return parent[n];
	}

	void merge(int from, int to) {
		int f = find(from);
		int t = find(to);
		if (f == t) return;

		parent[f] = t;
	}

};

int main() {
	Solution* s = new Solution();

	string st = "dcab";
	vector<vector<int>> vint{ {0,3},{1,2},{0,2} };
	cout << s->smallestStringWithSwaps(st, vint) << endl;
}


