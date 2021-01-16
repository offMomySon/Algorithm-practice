#include<iostream>
#include<vector>
#include<algorithm>


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
	void  check(TreeNode* treeA, TreeNode* treeB) {

		if (checkHelper(treeA, treeB)) {
			cout << "equal" << endl;
		}
		else {
			cout << "not equal" << endl;
		}

	}

	bool checkHelper(TreeNode* treeA, TreeNode* treeB) {
		if (treeA == nullptr && treeB == nullptr) {
			return true;
		}
		else if (treeA == nullptr && treeB != nullptr) {
			return false;
		}
		else if (treeA != nullptr && treeB == nullptr) {
			return false;
		}

		if (checkHelper(treeA->left, treeB->left) == false) {
			return false;
		}

		if (treeA->val != treeB->val) {
			return false;
		}

		if (checkHelper(treeA->right, treeB->right) == false) {
			return false;
		}

		return true;
	}
};


int main() {
	Solution* s = new  Solution();


	TreeNode* node = new TreeNode(1, new TreeNode(2, new TreeNode(4, NULL, NULL), NULL),  new TreeNode(3, NULL, NULL));
	TreeNode* node2 = new TreeNode(1, new TreeNode(2, NULL, NULL), new TreeNode(3, NULL, NULL));

	s->check(node, node2);
}




