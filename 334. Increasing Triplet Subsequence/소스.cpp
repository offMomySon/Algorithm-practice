#include<iostream>
#include<vector>
#include<stack>
#include<algorithm>

using namespace std;

class Solution {
public:
	bool increasingTriplet(vector<int>& nums) {
		if (nums.size() < 3)
			return false;

		vector<int> numList;

		for (auto num : nums) {
			auto it = lower_bound(numList.begin(), numList.end(), num);

			if (it == numList.end()) {
				numList.push_back(num);
			}
			else {
				(*it) = num;
			}

			if (numList.size() == 3)
				return true;
		}

		return false;
	}
};

int main() {

}