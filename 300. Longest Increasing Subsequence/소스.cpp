#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class Solution {
public:
	//int lengthOfLIS(vector<int>& nums) {
	//	vector<int> res;
	//
	//	for (auto num : nums) {
	//		auto it = lower_bound(res.begin(), res.end(), num);
	//
	//		if (it == res.end()) {
	//			res.push_back(num);
	//		}
	//		else {
	//			*it = num;
	//		}
	//	}
	//
	//	return res.size();
	//}

	int lengthOfLIS(vector<int>& nums) {
		vector<int> dp(nums.size(), 1);

		for (int i = 1; i < nums.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					if (1 + dp[j] > dp[i]) {
						dp[i] = dp[j] + 1;
					}
				}
			}
		}

		int res = 0;

		for (auto num : dp) {
			res = max(res, num);
		}
		return res;
	}
};

int main() {

}