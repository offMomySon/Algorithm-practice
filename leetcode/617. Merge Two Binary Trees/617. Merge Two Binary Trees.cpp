#include<iostream>

using namespace std;


struct TreeNode {
      int val;
	  TreeNode*left;
	  TreeNode*right;
	  TreeNode() : val(0), left(nullptr), right(nullptr) {}
	  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
	  TreeNode(int x, TreeNode*left, TreeNode*right) : val(x), left(left), right(right) {}
};
 


int main() {
	TreeNode*tree1 = new TreeNode(1,new TreeNode(3,new TreeNode(5,nullptr, nullptr) ,nullptr), new TreeNode(2, nullptr, nullptr));
	TreeNode* tree2 = new TreeNode(2, new TreeNode(1, nullptr, new TreeNode(4, nullptr, nullptr)), new TreeNode(3, nullptr, new TreeNode(7, nullptr, nullptr)));

	
}

TreeNode* mergeTrees(TreeNode* t1, TreeNode* t2) {
	if (t1 == nullptr && t2 == nullptr) {
		return nullptr;
	}
	else if(t1==nullptr){
		return t2;
	}
	else if (t2 == nullptr) {
		return t1;
	}

	
	t1->left = mergeTrees(t1->left, t2->left);
	t1->right = mergeTrees(t1->right, t2->right);
	t1->val = t1->val + t2->val;
	return t1;
}


