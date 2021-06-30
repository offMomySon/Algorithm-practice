#include<vector>
#include<iostream>

using namespace std;


class Solution {
public:
	vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
		vector<vector<int>> res;
		vector<int> com;
		combination(target, 0, com, candidates, res);
		return res;
	}
private: 
	void combination(int target, int idx,vector<int> &com, vector<int>& candidates, vector<vector<int>> &res) {
		if (target < 0) {
			return;
		}
		else if (target == 0) {
			res.push_back(com);
		}

		for (int i = idx; i < candidates.size(); i++) {
			com.push_back(candidates[i]);
			combination(target - candidates[i], i, com, candidates, res);
			com.pop_back();
		}
	}

};

int main() {

}
