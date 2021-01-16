#include <iostream>
#include <vector>
#include <set>
#include <map>

using namespace std;

class Solution {
public:
	//int singlenumber(vector<int>& nums) {
	//	int result=0;
	//	map<int,int> numbercount;

	//	for (int i = 0; i < nums.size(); i++ ) {
	//		if (numbercount.find(nums[i]) != numbercount.end()) {
	//			numbercount[nums[i]] += 1;
	//		}
	//		else {
	//			numbercount[nums[i]] = 1;
	//		}
	//	}

	//	for (auto it= numbercount.begin() ; it != numbercount.end(); it++) {
	//		if (it->second == 1) {
	//			result = it->first;
	//			break;
	//		}
	//	}

	//	return result;
	//}

	int singleNumber(vector<int>& nums) {
		for (int i = 1; i < nums.size(); i++) {
			nums[0] ^= nums[i];
		}
		return nums[0];
	}
};


int main() {
	Solution* s = new Solution();

	vector<int> v({ 2,2,2,2,4 });
	cout << s->singleNumber(v);
}


