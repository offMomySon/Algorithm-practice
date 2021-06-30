#include<iostream>
#include<vector>

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
	vector<int> inorderTraversal(TreeNode* root) {
		vector<int> result;

		return result;
	}
	vector<int> inorder(TreeNode* root, vector<int>& result) {
		if (root == NULL) {
			return;
		}

		if (root->left != NULL) {
			inorder(root->left, result);
		}
		result.push_back(root->val);
		if (root->right != NULL) {
			inorder(root->right, result);
		}

	}
};

int main() {

}