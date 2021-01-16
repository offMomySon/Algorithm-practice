#include <iostream>
#include<vector>


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
	int kthSmallest(TreeNode* root, int k) {
		int count = 0;
		return searchTree(root, k, count);
	}

private:
	int searchTree(TreeNode* root, int &k, int &count) {
		if (root == NULL) {
			return -1;
		}

		int res = searchTree(root->left, k, count);
		if (res != -1) {
			return res;
		}

		count++;
		if (k == count) {
			return root->val;
		}

		return searchTree(root->right, k, count);
	}
};

using namespace std;

int main() {

}