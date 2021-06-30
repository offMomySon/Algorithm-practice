#include<iostream>

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
	TreeNode* invertTree(TreeNode* root) {
		if (root == NULL) {
			return NULL;
		}

		TreeNode* tempTree = root->left;
		root->left = invertTree(root->right);
		root->right = invertTree(root->left);

		return root;
	}

};

int main() {


	TreeNode* tree = new TreeNode(4, new TreeNode(2, new TreeNode(1, NULL, NULL), new TreeNode(3, NULL, NULL)), new TreeNode(7, new TreeNode(6, NULL, NULL), new TreeNode(9, NULL, NULL)));

}