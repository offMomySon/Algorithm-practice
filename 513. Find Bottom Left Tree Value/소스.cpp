#include<iostream>
#include<vector>
#include<queue>

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
	int findBottomLeftValue(TreeNode* root) {
		
		queue< TreeNode*> q;
		q.push(root);
		
		int lastNum = 0;
		while (!q.empty()) {
			TreeNode* tree = q.front();
			q.pop();
			
			if (tree->right != NULL) {
				q.push(tree->right);
			}
			if (tree->left != NULL) {
				q.push(tree->left);
			}

			lastNum = tree->val;
		}

		return lastNum;
	}

};


int main() {

}

