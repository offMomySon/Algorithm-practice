#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;


class Solution {
public:
	vector<int> robMoney;

	int rob(vector<int>& nums) {
		if (nums.empty()) {
			return 0;
		}
		robMoney = vector<int>(nums.size(), -1);

		return robHelper(nums, 0);
	}


	int robHelper(vector<int>& nums, int th) {
		if (th == nums.size() - 1) {
			return nums[th];
		}
		if (th == nums.size() - 2) {
			return max(nums[th], nums[th+1]);
		}

		if (robMoney[th] != -1) {
			return robMoney[th];
		}
		return robMoney[th] = max(nums[th] + robHelper(nums, th + 2), robHelper(nums, th + 1));
	}

};

int main() {

}

