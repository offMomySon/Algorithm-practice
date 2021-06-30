#include<iostream>

using namespace std;

struct TreeNode {
     int val;
	 TreeNode*left;
	 TreeNode*right;
	 TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
	TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {

	}

	TreeNode* dfsTraverser(TreeNode* root, TreeNode* p, TreeNode* q) {
		if (root == NULL || root == p || root == q)
			return root;
		TreeNode* left = dfsTraverser(root->left, p, q);
		TreeNode* right = dfsTraverser(root->right, p, q);

		if (left && right)
			return root;
		
		return left ? left : right;
	}
};