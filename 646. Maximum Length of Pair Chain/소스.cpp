#include<vector>
#include<iostream>
#include<algorithm>

using namespace std;


class Solution {
public:
	//int findLongestChain(vector<vector<int>>& pairs) {
	//	sort(pairs.begin(), pairs.end(), cmp);
	//	
	//	vector<vector<int>> chain;
	//	chain.push_back(pairs[0]);
	//
	//	int idx = 1;
	//	while (idx < pairs.size()) {
	//		while (idx < pairs.size() && chain[chain.size() - 1][1] >= pairs[idx][0]) idx++;
	//
	//		if (idx >= pairs.size())
	//			break;
	//		chain.push_back(pairs[idx]);
	//	}
	//
	//	return chain.size();
	//}

	int findLongestChain(vector<vector<int>>& pairs) {
		sort(pairs.begin(), pairs.end(), cmp);


		int idx = 0;
		int count = 0;

		while (idx < pairs.size()) {
			count++;
			int curEnd = pairs[idx][1];

			while (idx < pairs.size() && curEnd >= pairs[idx][0]) idx++;
		}

		return count;
	}

private:
	static bool cmp(vector<int>& a, vector<int>& b) {
		return a[1] < b[1];
	}

};

int main() {

}