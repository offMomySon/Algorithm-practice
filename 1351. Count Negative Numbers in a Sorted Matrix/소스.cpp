#include<iostream>
#include<vector>

using namespace std;
//시작시작 - 03:00
//날짜 - 2021/02/24
//실수 - binary search 시 base case 에 대해잘못 생각함.
class Solution {
public:
	int countNegatives(vector<vector<int>>& grid) {
		int count = 0;

		for (int i = 0; i < grid.size(); i++) {
			count += (grid[i].size() - binary_search(grid[i], 0, grid[i].size() - 1) );
		}

		return count;
	}


	int binary_search(vector<int>& grid, int start, int end) {
		if (start > end)
			return start;


		if (grid[(start+end) / 2] >= 0) {
			return binary_search(grid, (start+end) / 2 + 1, end);
		}
		else {
			return binary_search(grid, start, (start+end) / 2-1);
		}
	}
};

int main() {
	Solution* s = new Solution();

	vector<vector<int>> vec({ {4, 3, 2, -1},{3, 2, 1, -1},{1, 1, -1, -2},{-1, -1, -2, -3} });
	//vector<vector<int>> vec({ {-1} });


	cout << s->countNegatives(vec);

}