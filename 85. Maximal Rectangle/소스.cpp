#include<iostream>
#include<vector>
#include<stack>
#include<algorithm>

using namespace std;

class Solution {
public:
	vector<vector<int>> heightCal;

	int maximalRectangle(vector<vector<char>>& matrix) {
		if (matrix.size() <= 0 || matrix[0].size() <= 0)
			return 0;
		heightCal = vector<vector<int>>(matrix.size(), vector<int>(matrix[0].size(), 0));

		for (int col = 0; col < matrix[0].size(); col++) {
			int cal = 0;
			for (int row = 0; row<matrix.size(); row++) {
				if (matrix[row][col] == '0') {
					cal = 0;
				}
				else {
					cal += 1;
				}
				heightCal[row][col] = cal;
			}
		}

		int height = matrix.size();
		int length = matrix[0].size();

		int maxNum = 0;
		for (int row = 0; row < height; row++) {
			stack<int> st;
			vector<int> leftIdx(length, -1);
			vector<int> rightIdx(length, length);
			
			st.push(0);
			for (int col = 1; col < length; col++) {
				while (!st.empty()) {
					if (heightCal[row][st.top()] >= heightCal[row][col])
						st.pop();
					else
						break;
				}
				if (st.empty())
					leftIdx[col] = -1;
				else
					leftIdx[col] = st.top();

				st.push(col);
			}

			while (!st.empty()) {
				st.pop();
			}
				
			st.push(length - 1);
			for (int col = length-2; col >= 0; col--) {
				while (!st.empty()) {
					if (heightCal[row][st.top()] >= heightCal[row][col])
						st.pop();
					else
						break;
				}
				if (st.empty())
					rightIdx[col] = length;
				else
					rightIdx[col] = st.top();

				st.push(col);
			}

			for (int col = 0; col < length; col++) {
				maxNum = max(maxNum, heightCal[row][col] * (rightIdx[col] - leftIdx[col] - 1));
			}
		}

		return maxNum;
	}
};

int main() {
	Solution* s = new Solution();
	vector<vector<char>> vec ({
		{'1','0','1','0','0'},
		{'1','0','1','1','1'},
		{'1','1','1','1','1'},
		{'1','0','0','1','0'}
	});

	cout << s->maximalRectangle(vec);
}


