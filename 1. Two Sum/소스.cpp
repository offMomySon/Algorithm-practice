#include<iostream>
#include<vector>
#include<unordered_map>

using namespace std;

class Solution {
public:
	vector<int> twoSum(vector<int>& nums, int target) {
		unordered_map<int,int> valueMap;

		for (int num : nums) {
			valueMap[num]++;
		}

		vector<int> resultNum(2, 0);
		for (int num : nums) {
			if (valueMap.find(target - num) != valueMap.end()) {
				resultNum[0] = num;
				resultNum[1] = target - num;
			}
		}

		vector<int> result(2,0);
		int idx = 0;
		int selecteIdx = -1;

		for (int i = 0; i < resultNum.size(); i++) {
			for (int j = 0; j < nums.size(); j++) {
				if (selecteIdx == j)
					continue;

				if (resultNum[i] == nums[j]) {
					result[idx] = j;

					selecteIdx = j;

					idx++;
					break;
				}
			}
		}
		
		return result;
	}
};