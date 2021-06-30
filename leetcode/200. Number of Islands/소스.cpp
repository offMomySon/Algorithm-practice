#include<vector>
#include<iostream>

using namespace std;

class Solution {
public:
	// right, down, left, top
	int move[4][2] = { {0,1},{1,0}, {0, -1}, {-1,0} };

	int numIslands(vector<vector<char>>& grid) {
		vector<vector<bool>> isVisited(grid.size(), vector<bool>(grid[0].size(), false));
		int count = 0;

		for (int i = 0; i < grid.size(); i++) {
			for (int j = 0; j < grid[i].size(); j++) {
				if (isVisited[i][j] == false && grid[i][j] - '1' == 0) {
					count += 1;
				}
				checkConnectedLand(grid, isVisited, i, j);
			}
		}

		return count;
	}

	void checkConnectedLand(vector<vector<char>>& grid, vector<vector<bool>>& isVisited, int row, int col ) {
		if (grid[row][col] - '0' == 0 || isVisited[row][col]) {
			return;
		}

		isVisited[row][col] = true;
		for (int i = 0; i < 4; i++) {
			if (row + move[i][0] >= grid.size())
				continue;
			if (col + move[i][1] >= grid[0].size())
				continue;

			checkConnectedLand(grid, isVisited, row + move[i][0], col + move[i][1]);
		}
	}
};

int main() {
	Solution* s = new Solution();
	vector<vector<char>> map({
		{'1', '1', '0', '0', '0'},
		{'1', '1', '0', '0', '0'},
		{'0', '0', '1', '0', '0' },
		{'0', '0', '0', '1', '1'}
		});
	cout << s->numIslands(map);
}



