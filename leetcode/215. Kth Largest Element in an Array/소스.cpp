#include<iostream>
#include<set>
#include<algorithm>
#include<vector>
#include<queue>

using namespace std;

struct Cmp
{
	bool operator()(const int& lhs, const int& rhs)
	{
		return lhs < rhs;
	}
};
class Solution {
public:
	int findKthLargest(vector<int>& nums, int k) {
		//set<int> numSet;
		//for (int num : nums) {
		//	numSet.insert(num);
		//}
		//
		//vector<int> vec(numSet.begin(), numSet.end());
		//sort(nums.begin(), nums.end(), compare);

		//return nums[k - 1];

		priority_queue<int, vector<int>, Cmp> pq;
		
		for (int num : nums) {
			pq.push(num);
		}

		int n;
		for (int i = 0; i < k-1; i++) {
			//n = pq.top();
			pq.pop();
		}

		return pq.top();
	}
};

int main() {
	vector<int> vec({ 3,2,3,1,2,4,5,5,6 });
	Solution* s = new Solution();
	int n = s->findKthLargest(vec, 4);
	cout << n;
}

