#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class Solution {
public:
	bool searchMatrix(vector<vector<int>>& matrix, int target) {
		if (matrix.empty())
			return false;
		if (matrix[0].empty())
			return false;

		int row = matrix.size()-1;
		int col = 0;

		while (0 <= row && col < matrix[0].size()) {
			if (matrix[row][col] == target) {
				return true;
			}

			if (matrix[row][col] < target) {
				col++;
			}
			else {
				row--;
			}

		}

		return false;
	}

	//bool searchHelper(vector<vector<int>>& matrix, int target, int w, int h) {
	//	if (h >= matrix.size())
	//		return false;
	//	if (w >= matrix[h].size())
	//		return false;

	//	int init_w = w;
	//	int init_h = h;

	//	if (matrix[h][w] == target)
	//		return true;

	//	while (true) {

	//		if (h + 1 >= matrix.size())
	//			break;
	//		if (w + 1 >= matrix[h + 1].size())
	//			break;

	//		if (matrix[h+1][w+1] == target)
	//			return true;

	//		if (matrix[h+1][w+1] > target){
	//			break;
	//		}

	//		++h;
	//		++w;
	//	}

	//	return searchHelper(matrix, target, w + 1, init_h) || searchHelper(matrix, target, init_w, h + 1);
	//}

};



int main() {
	vector<vector<int>> vv = { 
	{ 1 , 4, 7,11,15 }, 
	{ 2 , 5, 8,12,19 }, 
	{ 3 , 6, 9,16,22 }, 
	{ 10,13,14,17,24 },
	{ 18,21,23,26,30 } };

	Solution* s = new Solution();
	cout <<  s->searchMatrix(vv, 20);

}