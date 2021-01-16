#include<iostream>
#include<vector>
#include<unordered_map>
#include<algorithm>

using namespace std;

class Solution {
public:
	int majorityElement(vector<int>& nums) {

		sort(nums.begin(), nums.end(), greater<int>());

		return nums[nums.size()/2];
	}
};

int main() {
	Solution* s = new Solution();

	vector<int> v({ 2,2,1,1,1,2,2 });
	cout << s->majorityElement(v);
}

