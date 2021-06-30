#include<iostream>

using namespace std;

struct TreeNode {
	int val;
	TreeNode* left;
	TreeNode* right;
	TreeNode() : val(0), left(nullptr), right(nullptr) {}
	TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
};

class Solution {
public:
	bool isSymmetric(TreeNode* root) {
		if (root == NULL) {
			return true;
		}
		
		return eachTravel(root->left, root->right);
	}

	bool eachTravel(TreeNode* left, TreeNode* right) {
		if (left == NULL && right == NULL) {
			return true;
		}
		if (left != NULL && right == NULL) {
			return false;
		}
		if (left == NULL && right != NULL) {
			return false;
		}

		if (left->val != right->val) {
			return false;
		}

		if (eachTravel(left->right, right->left) == false) {
			return false;
		}
		if (eachTravel(left->left, right->right) == false) {
			return false;
		}

		return true;
	}
};