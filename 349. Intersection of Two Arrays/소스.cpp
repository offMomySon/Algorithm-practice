#include<iostream>
#include<vector>
#include<unordered_map>

using namespace std;


class Solution {
public:
	vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
		unordered_map<int, int> num_one_map;
		unordered_map<int, int> num_two_map;

		for (auto num : nums1) {
			num_one_map[num] = 1;
		}
		for (auto num : nums2) {
			num_two_map[num] = 1;
		}

		vector<int> res;
		for (auto it = num_one_map.begin(); it != num_one_map.end(); it++) {
			if (num_two_map.find(it->first) != num_two_map.end()) {
				res.push_back(it->first);
			}
		}

		return res;
	}
};

int main() {

	Solution* s = new Solution();

	//vector<int> nums1({ 1,2,2,1 });
	//vector<int> nums2({ 2,2 });

	vector<int> nums1({ 4,9,5 });
	vector<int> nums2({ 9,4,9,8,4 });

	vector<int> res = s->intersection(nums1, nums2);
	for (auto n : res)
		cout << n << " ";

}