#include<iostream>
#include<vector>

using namespace std;
//���۽��� - 03:00
//��¥ - 2021/02/24
//�Ǽ� - binary search �� base case �� �����߸� ������. , key �� 0���� ���� ��� right value ������ �߸� ������.
//���� - https://blog.joonas.io/153
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