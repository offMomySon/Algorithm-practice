#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
	vector<vector<int>> subsets(vector<int>& nums) {
		vector<vector<int>> result;
		vector<int> sub;
		makeSubset(nums, 0, result, sub);
		return result;
	}

private:
	void makeSubset(vector<int>& nums,int th, vector<vector<int>> &result, vector<int>sub) {
		result.push_back(sub);
		if (th == nums.size()) {
			return;
		}

		sub.push_back(nums[th]);
		makeSubset(nums, th + 1, result, sub);
		sub.pop_back();
		makeSubset(nums, th + 1, result, sub);
	}
};

int main() {
	Solution* s = new Solution();

	vector<int> sett({ 1,2,3 });
	vector<vector<int>> result = s->subsets(sett);

}