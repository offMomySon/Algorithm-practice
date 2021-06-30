#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;


class Solution {
public:
	vector<int> findDisappearedNumbers(vector<int>& nums) {
		for (int i = 0; i < nums.size(); i++) {
			int targetIdx = abs(nums[i]) - 1;
			
			nums[targetIdx] = nums[targetIdx] ? -nums[targetIdx] : nums[targetIdx];

		}

		vector<int> res;
		for (int i = 0; i < nums.size(); i++) {
			if (nums[i] > 0) {
				res.push_back(i + 1);
			}
		}

		return res;
	}
};

int main() {
	Solution* s = new Solution();
	vector<int> vec({ 4,3,2,7,8,2,3,1 });
	vec = s->findDisappearedNumbers(vec);

	for (int num : vec) {
		cout << num << endl;
	}
}

