//#include<iostream>
//#include<vector>
//#include<algorithm>
//
//using namespace std;
//
// struct TreeNode {
//     int val;
//     TreeNode *left;
//     TreeNode *right;
//     TreeNode() : val(0), left(nullptr), right(nullptr) {}
//     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
//     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
//};
//
//class Solution {
//public:
//	TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
//		return buildHelper(preorder, inorder, 0, preorder.size() - 1, 0, inorder.size() - 1 );
//	}
//
//	TreeNode* buildHelper(vector<int>& preorder, vector<int>& inorder, int preStart, int preEnd, int inStart, int inEnd) {
//		if (inStart > inEnd) {
//			return NULL;
//		}
//
//
//		TreeNode* tree = new TreeNode(preorder[preStart]);
//
//		int rootPos;
//		for (int i = inStart; i <= inEnd; i++) {
//			if (inorder[i] == preorder[preStart]) {
//				rootPos = i;
//			}
//		}
//	
//		tree->left = buildHelper(preorder, inorder, preStart + 1, rootPos + preStart -inStart  , inStart, rootPos - 1);
//		tree->right = buildHelper(preorder, inorder, preEnd -inEnd+rootPos+1, preEnd,  rootPos+1, inEnd);
//		
//		return tree;
//	}
//};
//
//
//
//
////preorder = [3, 9, 20, 15, 7]
////inorder =  [9, 3, 15, 20, 7]
////           15  20  9  3 
//
////Return the following binary tree :
////
////3
///// \
////9  20
///// \
////15   7
