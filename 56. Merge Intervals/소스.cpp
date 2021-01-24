#include<vector>
#include<iostream>
#include<algorithm>

using namespace std;

class Solution {

public:
	static bool cmp(vector<int>& a, vector<int>& b) {
		return a[0] < b[0];
	}

	vector<vector<int>> merge(vector<vector<int>>& intervals) {
		vector<bool> map(10000, false);
		int lastIdx = 0;

		sort(intervals.begin(), intervals.end(), cmp);

		vector<vector<int>> res;
		res.push_back(intervals[0]);
		
		for (int i = 1; i < intervals.size(); i++) {
			if (res.back()[1] >= intervals[i][0]) {
				res.back()[1] = max(res.back()[1], intervals[i][1]);
			}
			else {
				res.push_back(intervals[i]);
			}
		}

		return res;
	}
};

