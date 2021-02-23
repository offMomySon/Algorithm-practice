#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;


class Solution {
public:
	int largestAltitude(vector<int>& gain) {
		int higestNum = 0;
		int curNum = 0;

		for (auto num : gain) {
			curNum += num;
			higestNum = max(curNum, higestNum);
		}

		return higestNum;
	}
};

int main() {




}