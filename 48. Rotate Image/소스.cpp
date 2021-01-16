#include<iostream>
#include<vector>

using namespace std;


class Solution {
public:
	void rotate(vector<vector<int>>& matrix) {
		int mLen = matrix.size();

		for (int i = 0; i < mLen / 2; i++) {
			for (int j = i; j < mLen - 1 - i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[mLen - 1 - j][i];
				matrix[mLen - 1 - j][i] = matrix[mLen - 1 - i][mLen - 1 - j];
				matrix[mLen - 1 - i][mLen - 1 - j] = matrix[j][mLen - 1 - i];
				matrix[j][mLen - 1 - i] = temp;



			}
		}

	}
};

int main() {

}