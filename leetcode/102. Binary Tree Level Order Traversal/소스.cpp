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
	vector<vector<int>> levelOrder(TreeNode* root) {
		if (root == NULL) {
			return {};
		}

		vector<vector<int>> res;
		queue<TreeNode*> q;
		q.push(root);

		while(!q.empty()) {
			vector<TreeNode*> vec;
			vector<int> values;

			while (!q.empty()) {
				values.push_back(q.front()->val);
				vec.push_back(q.front());
				q.pop();
			}
			res.push_back(values);

			for (TreeNode* tnode : vec) {
				if (tnode->left != NULL) {
					q.push(tnode->left);
				}
				if (tnode->right != NULL) {
					q.push(tnode->right);
				}
			}
		}

		return res;
	}
};


int main() {

}


