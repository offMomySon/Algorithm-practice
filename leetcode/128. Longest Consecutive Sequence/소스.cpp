#include<iostream>
#include<vector>
#include<unordered_map>

using namespace std;
class Solution {
public:
	int longestConsecutive(vector<int>& nums) {
		unordered_map<int, int> map;
		int minNum = INT_MAX;
		int maxNum = INT_MIN;

		for (int num : nums) {
			map[num]++;
			if (num > maxNum) maxNum = num;
			if (minNum > num) minNum = num;
		}

		int longestConsec = 0;
		int count = 0;
		for (int i = minNum; i <= maxNum; i++) {
			if (map[i] > 0) {
				count++;
			}
			else {
				if (count > longestConsec) {
					longestConsec = count;
				}
				count = 0;
			}

		}

		if (count > longestConsec) longestConsec = count;

		return longestConsec;
	}
};

int main() {
	Solution* s = new Solution();
	vector<int> v({ 9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6 });
	cout <<s->longestConsecutive(v);

}






