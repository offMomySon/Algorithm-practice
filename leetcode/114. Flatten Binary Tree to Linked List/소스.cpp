#include<iostream>
#include<vector>
#include<algorithm>

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
	void flatten(TreeNode* root) {
		if (root == NULL) {
			return;
		}

		flatten(root->left);
		flatten(root->right);	

		if (root->left != NULL) {
			TreeNode* right = root->right;

			root->right = root->left;
			root->left = NULL;

			while (root->right != NULL) {
				root = root->right;
			}

			root->right = right;
		}
	}

	TreeNode* flattenHelper(TreeNode* root) {
		if (root == NULL) {
			return NULL;
		}

		TreeNode* leftNodeTail = flattenHelper(root->left);
		TreeNode* rightNodeTail = flattenHelper(root->right);

		TreeNode* right = root->right;
		if (root->left != NULL) {
			root->right = root->left;
			root->left = NULL;
			leftNodeTail->right = right;
		}

		if (rightNodeTail != NULL) {
			return rightNodeTail;
		}
		else if (leftNodeTail != NULL) {
			return leftNodeTail;
		}
		else {
			return root;
		}

	}
};

int main() {
	Solution* s = new Solution();

	TreeNode* node = new TreeNode(1, new TreeNode(2, new TreeNode(3, NULL, NULL), new TreeNode(4, NULL, NULL)), new TreeNode(5, NULL, new TreeNode(6, NULL, NULL)));

	s->flatten(node);

}








