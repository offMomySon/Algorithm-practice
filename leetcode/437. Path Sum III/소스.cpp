
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
	int pathSum(TreeNode* root, int sum) {
		if (root == nullptr) {
			return 0;
		}

		return subSum(root, 0, sum) + pathSum(root->left,sum) + pathSum(root->right, sum);
	}

private:
	int subSum(TreeNode* root, int pre, int& sum) {
		if (root == nullptr) {
			return 0;
		}

		int cur = root->val + pre;
		if ( cur == sum)
		{
			return 1 + subSum(root->left,cur, sum) + subSum(root->right, cur,sum);
		}
		return subSum(root->left, cur, sum) + subSum(root->right, cur, sum);
	}

};