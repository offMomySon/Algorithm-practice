#include<iostream>
#include<vector>
#include<algorithm>
#include<cmath>

using namespace std;

class Solution {
public:
	vector<vector<int>> dp;
	int maximalSquare(vector<vector<char>>& matrix) {
		int width = matrix.size();
		int length = matrix[0].size();

		dp = vector<vector<int>>(matrix.size(), vector<int>(matrix[0].size(),-1));
		for (int j = 0; j < length; j++) {
			dp[width - 1][j] = matrix[width - 1][j] - '0';
		}
		for (int i = 0; i < width; i++) {
			dp[i][length - 1] = matrix[i][length - 1] - '0';
		}

		int res = 0;

		for (int i = 0; i < matrix.size(); i++) {
			for (int j = 0; j < matrix[i].size(); j++) {
				res = max(calMax(i, j, matrix, dp), res);
			}
		}

		return res*res;
	}

	int calMax(int row, int col, vector<vector<char>>& matrix, vector<vector<int>>& dp) {
		if (matrix[row][col] == '0')
			return dp[row][col] = 0;

		if (dp[row][col] != -1)
			return dp[row][col];
		
		return dp[row][col] = min(min(calMax(row + 1, col, matrix, dp), calMax(row, col + 1, matrix, dp)), calMax(row + 1, col + 1, matrix, dp))+1;
	}
};

int main() {
	Solution* s = new Solution();
	vector<vector<char>> map = {
		{'1', '0', '1', '0', '0'},
		{'1', '0', '1', '1', '1'},
		{'1', '1', '1', '1', '1'},
		{'1', '0', '0', '1', '0'}
	};

	cout <<s->maximalSquare(map);
}