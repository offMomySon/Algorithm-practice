#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
	void moveZeroes(vector<int>& nums) {
		int targetIdx = 0;

		for (int i = 0; i < nums.size(); i++) {
			if (nums[i] == 0) {
				continue;
			}

			if (targetIdx != i) {
				swap(nums[targetIdx], nums[i]);
			}
			targetIdx++;
		}

	}

};

int main() {
	vector<int> nusms({ 0,1,0,3,12 });

	Solution* s = new Solution();
	s->moveZeroes(nusms);

	for (int num : nusms) {
		cout << num << " ";
	}
}