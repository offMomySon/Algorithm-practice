#include<iostream>
#include<vector>
#include<set>
#include<deque>

using namespace std;

//class Solution {
//public:
//	vector<int> maxSlidingWindow(vector<int>& nums, int k) {
//		vector<int> res;
//		multiset<int, greater<int>> s;
//
//		for (int i = 0; i < k; i++) {
//			s.insert(nums[i]);
//		}
//
//		res.push_back(*s.begin());
//
//		for (int i = k; i < nums.size() ; i++) {
//			s.insert(nums[i]);
//			s.erase(s.find(nums[i - k]));
//			
//			res.push_back(*s.begin());
//		}
//
//		return res;
//	}
//};

class Solution {
public:
	vector<int> maxSlidingWindow(vector<int>& nums, int k) {
		deque<int> dq;
		vector<int> res;
		for (int i = 0; i < nums.size(); i++) {
			if (!dq.empty() && dq.front() < i - k + 1) {
				dq.pop_front();
			}

			while (!dq.empty() && nums[dq.back()] < nums[i]) {
				dq.pop_back();
			}
			dq.push_back(i);

			if (i >= k - 1)
				res.push_back(nums[dq.front()]);
		}
		return res;
	}
};


int main() {
	
	vector<int> vv({ -7,-8,7,5,7,1,6,0 });
	Solution* s = new Solution();
	vector<int> v = s->maxSlidingWindow(vv, 4);

	for (auto it = v.begin(); it != v.end(); it++) {
		cout << *it << endl;
	}
}