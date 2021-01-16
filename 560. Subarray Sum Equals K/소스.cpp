#include<iostream>
#include<vector>
#include<deque>
#include<unordered_map>

using namespace std;

class Solution {
public:
	int subarraySum(vector<int>& nums, int k) {
		unordered_map<int, int> m;
		int curTotal = 0;
		int count = 0;

		for (auto num : nums) {
			curTotal += num;
			
			if (curTotal == k) {
				count++;
			}

			if (m.find(curTotal - k) != m.end()) {
				count += m[curTotal - k];
			}

			m[curTotal]++;

		}
		return count;
	}
};

int main() {

}

