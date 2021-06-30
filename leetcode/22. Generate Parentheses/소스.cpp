#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
	vector<string> generateParenthesis(int n) {
		vector<string> res;
		makeParenthe(n, 0, 0, res, "");
		return res;
	}
private:
	void makeParenthe(int &n, int left, int right, vector<string> &res, string str) {
		if (left+right == 2*n) {
			res.push_back(str);
			return;
		}

		if (left < n) {
			makeParenthe(n, left + 1, right, res, str + "(");
		}
		if (left > right) {
			makeParenthe(n, left, right + 1, res, str + ")");
		}
	}
};

int main() {

}