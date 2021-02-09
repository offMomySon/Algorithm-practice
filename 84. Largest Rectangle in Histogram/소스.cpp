#include<iostream>
#include<vector>
#include<stack>
#include<algorithm>

using namespace std;

class Solution {
public:
	int largestRectangleArea(vector<int>& heights) {
		vector<int> left_idx(heights.size(), -1);
		vector<int> right_idx(heights.size(), heights.size());

		stack<int> st;
		st.push(0);
		for (int i = 1; i < heights.size(); i++) {
			while (!st.empty()) {
				int stH = heights[st.top()];
				if (stH >= heights[i])
					st.pop();
				else
					break;
			}

			if (st.empty())
				left_idx[i] = -1;
			else
				left_idx[i] = st.top();

			st.push(i);
		}

		stack<int> st_b;
		st_b.push(heights.size()-1);
		for (int i = heights.size()-2 ; i >= 0; i--) {
			while (!st_b.empty()) {
				int stH = heights[st_b.top()];
				if (stH >= heights[i])
					st_b.pop();
				else
					break;
			}

			if (st_b.empty())
				right_idx[i] = heights.size()	;
			else
				right_idx[i] = st_b.top();

			st_b.push(i);
		}

		int maxNum = 0;
		for (int i = 0; i < heights.size(); i++) {

			int left = 
			maxNum = max(heights[i] * (right_idx[i] - left_idx[i] - 1),maxNum);
		}
		return maxNum;
	}
};

int main() {
	Solution* s = new Solution();
	vector<int>  heights({ 2,4 });

	cout << s->largestRectangleArea(heights);
}
