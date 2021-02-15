#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class Solution {
public:
	static bool cmp(vector<int>&a, vector<int>& b) {
		if (a[0] != b[0])
			return a[0] < b[0];
		else
			return a[1] < b[1];
	}

	int eraseOverlapIntervals(vector<vector<int>>& intervals) {
		if (intervals.size() <= 0)
			return 0;

		int removeCount = 0;
		sort(intervals.begin(), intervals.end(), cmp);

		int prevEnd = intervals[0][1];
		for (int i = 1; i < intervals.size(); i++) {
			if (prevEnd > intervals[i][0]) {
				removeCount++;
				prevEnd = min(prevEnd, intervals[i][1]);
			}
			else
				prevEnd = intervals[i][1];
		}

		return removeCount;
	}
};

int main() {
	Solution* s = new Solution();
	vector<vector<int>> v({ { 1,2} ,{2,3},{3,4},{1,3} });
	cout << s->eraseOverlapIntervals(v);
};

