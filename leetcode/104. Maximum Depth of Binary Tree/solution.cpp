#include <iostream>
#include<cmath>
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
private:
	int depth = 0;
public:
	int maxDepth(TreeNode* root) {
		if (root==nullptr) {
			return 0;
		}
	
		return 1 + max(maxDepth(root->left), maxDepth(root->right));
	}
};


int main() {
	Solution* s = new Solution();
	TreeNode* tree = new TreeNode(10, new TreeNode(10, nullptr, new TreeNode(10, nullptr, nullptr)), new TreeNode(10, nullptr, new TreeNode(10, nullptr, nullptr)));

	cout << s->maxDepth(tree);
}

