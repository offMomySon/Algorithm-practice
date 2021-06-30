#include<iostream>
#include<vector>
#include<algorithm>


using namespace std;


struct TreeNode {
	int val;
	TreeNode* left;
	TreeNode* right;
	TreeNode() : val(0), left(nullptr), right(nullptr) {}
	TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
	TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
	
};

class Solution {
public:
	int diameterOfBinaryTree(TreeNode* root) {
		int maxLen = 0;
		calDiameter(root, maxLen);

		return maxLen;
	}

	int calDiameter(TreeNode *root, int &maxLen) {
		if (root == NULL) {
			return 0;
		}
		
		int leftDiameter = calDiameter(root->left, maxLen);
		int rightDiameter = calDiameter(root->right, maxLen);

		maxLen = maxLen < leftDiameter+rightDiameter ? leftDiameter+rightDiameter: maxLen;

		return max(leftDiameter, rightDiameter) + 1;
	}
};


int main() {

}




