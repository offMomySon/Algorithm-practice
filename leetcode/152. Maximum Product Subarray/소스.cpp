#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class Solution {
public:
	vector<int> maxCache;
	vector<int> minCache;

	int maxProduct(vector<int>& nums) {

		int res = nums[0];
		int minV = res;
		int maxV = res;

		for (int i = 1; i < nums.size(); i++) {
			

			if (nums[i] < 0)
				swap(minV, maxV);
			
			minV = min(nums[i], minV * nums[i]);
			maxV = max(nums[i], maxV * nums[i]);

			res = max(res, maxV);
		}

		return res;
	}

	//int calMax(vector<int>& nums, int size) {
	//	
	//}

};

int main() {
	Solution* s = new Solution();
	vector<int> vec({ -2, 0, -1});

	cout << s->maxProduct(vec);

}