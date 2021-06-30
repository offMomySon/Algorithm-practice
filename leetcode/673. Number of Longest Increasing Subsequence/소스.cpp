#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;


class Solution {
public:
	int findNumberOfLIS(vector<int>& nums) {
		vector<int> len(nums.size(),1);
		vector<int> cnt(nums.size(),1);
		int res = 0;
		int maxLen = 0;

		for (int i = 1; i < nums.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					if (len[i] < len[j] + 1) {
						len[i] = len[j] + 1;
						cnt[i] = cnt[j];
					}
					else if (len[i] == len[j] + 1) {
						cnt[i] += cnt[j];
					}
				}
			}
		}

		for (int i = 0; i < nums.size(); i++) {
			if (maxLen == len[i]) {
				res += cnt[i];
			} else if(maxLen < len[i]){
				maxLen = len[i];
				res = cnt[i];
			}
		}



		return res;
	}
};

int main() {
	Solution* s = new Solution();
	vector<int> vv({ 2,2,5,4,7 });
	cout << s->findNumberOfLIS(vv);

}