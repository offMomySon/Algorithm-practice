#include<iostream>
#include<vector>
#include<algorithm>
#include<unordered_map>

using namespace std;



class Solution {
public:
	vector<vector<string>> groupAnagrams(vector<string>& strs) {
		unordered_map<string,vector<string>> map;
		
		for (string str : strs) {
			string tempStr = str;
			sort(tempStr.begin(), tempStr.end());
			map[tempStr].push_back(str);
		}

		vector<vector<string>> res;

		for (auto& p : map) {
			res.push_back(p.second);
		}

		return res;
	}

	bool cmp(pair<int,string> p1, pair<int,string> p2) {
		return p1.second < p2.second;
	}
};

int main() {

}