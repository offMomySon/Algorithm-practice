#include<iostream>
#include<vector>

using namespace std;

 struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
 
class Solution {
public:
	vector<vector<int>> res;

	vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
		if (root == NULL)
			return res;

		vector<int> v;
		pathSumHelper(root, v, 0, targetSum);
		
		return res;
	}

	void pathSumHelper(TreeNode* curNode, vector<int> &pathNum, int totalNum, int targetNum) {
		if (curNode->left == NULL && curNode->right == NULL) {
			if (totalNum + curNode->val == targetNum) {
				pathNum.push_back(curNode->val);
				res.push_back(pathNum);
				pathNum.pop_back();
			}
			return;
		}

		if (curNode->left != NULL) {
			pathNum.push_back(curNode->val);
			pathSumHelper(curNode->left, pathNum, totalNum + curNode->val, targetNum);
			pathNum.pop_back();
		}

		if (curNode->right != NULL) {
			pathNum.push_back(curNode->val);
			pathSumHelper(curNode->right, pathNum, totalNum + curNode->val, targetNum);
			pathNum.pop_back();
		}
	}
};

int main() {
	Solution* s = new Solution();
}