#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>

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
	 int rob(TreeNode* root) {
		 if (root == NULL) {
			 return 0;
		 }


		 return calRob(root, false);

	 }
 private:
	 int maxRob = 0;

	 int calRob(TreeNode* node, bool isBeforeSelected) {
		 if (node == NULL) {
			 return 0;
		 }

		 int curValue = 0;

		 if (isBeforeSelected) {
			 curValue += calRob(node->left, false);
			 curValue += calRob(node->right, false);

		 }
		 else {
			 int selecteValue = 0;
			 int notSelectedValue = 0;

			 selecteValue += calRob(node->left, true);
			 selecteValue += calRob(node->right, true);

			 notSelectedValue += calRob(node->left, false);
			 notSelectedValue += calRob(node->right, false);

			 curValue = selecteValue + node->val > notSelectedValue ? selecteValue + node->val : notSelectedValue;
		 }

		 return curValue;
	 }

 };


int main() {

}