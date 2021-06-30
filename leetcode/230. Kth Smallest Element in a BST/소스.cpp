#include <iostream>
#include<vector>


//날짜 - 2021/02/26
//시작 - 11:20
//종료 - 11:28
//실수 - 
//참조 - 
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
	int kthSmallest(TreeNode* root, int k) {
		int count = 0;
		
		return binarySearch(root, k, count);
	}

	int binarySearch(TreeNode* node, int k, int &count) {
		if (node == nullptr)
			return -1;

		int res = binarySearch(node->left, k, count);
		if (res != -1) {
			return res;
		}

		count++;
		if (count == k)
			return node->val;

		return binarySearch(node->right, k, count);
	}
};

int main() {

}