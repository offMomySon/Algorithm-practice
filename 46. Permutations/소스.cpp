#include<iostream>
#include <vector>
#include<algorithm>

using namespace std;

class Solution {
public:
	vector<vector<int>> permute(vector<int>& nums) {
		vector<vector<int>> result;
		makePermutation(nums, 0, result);
		return result;
	}


private:
	void makePermutation(vector<int>& nums, int begin, vector<vector<int>>& result) {
		if (begin == nums.size()) {
			result.push_back(vector<int>(nums));
		}

		for (int i = begin; i < nums.size(); i++) {
			swap(nums[begin], nums[i]);
			makePermutation(nums, begin + 1, result);
			swap(nums[begin], nums[i]);
		}
	}

};

int main() {
	Solution* s = new Solution();
	vector<int> temp = { 1,2,3 };
 	vector<vector<int>> r = s->permute(temp);

	for (auto i : r) {
		for (auto j : i) {
			cout << j;
		}
		cout << "\n";
	}
}