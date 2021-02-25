#include<iostream>
#include<vector>
#include<algorithm>
#include<set>

using namespace std;

class Solution {
public:
	set<vector<int>> s;
	int countValidTime(vector<int> nums) {


		countPossibleList(nums, 0);

		int res = 0;
		for (auto it = s.begin(); it != s.end(); it++) {
			int hour = (*it)[0] * 10 + (*it)[1];
			int min = (*it)[2] * 10 + (*it)[3];

			if (hour >= 24 || min >= 60)
				continue;
			res++;
		}

		return res;
	}

	void countPossibleList(vector<int>& nums, int depth) {
		if (nums.size() <= depth) {
			s.insert(nums);
		}

		int res = 0;
		for (int i = depth; i < nums.size(); i++) {
			swap(nums[depth], nums[i]);
			countPossibleList(nums, depth + 1);
			swap(nums[depth], nums[i]);
		}
	}
};



int main() {
	Solution* s = new Solution();
	vector<int> vec({ 2,4,2,4 });
	//cout<< s->countValidTime(2, 4, 2, 4);
	cout<< s->countValidTime(vec);
}