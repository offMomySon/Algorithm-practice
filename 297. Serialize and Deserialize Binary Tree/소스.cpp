#include<iostream>
#include<vector>
#include<string>
#include <sstream>

using namespace std;

struct TreeNode {
	int val;
	TreeNode* left;
	TreeNode* right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
	TreeNode(int x, TreeNode* leftT, TreeNode *rightT) : val(x), left(leftT), right(rightT) {}
};


class Codec {
public:

	// Encodes a tree to a single string.
	string serialize(TreeNode* root) {
		vector<string> encVec;
		serializeHelper(root, encVec);

		std::stringstream res;
		auto it = encVec.begin();

		res << *it++;
		for (; it != encVec.end(); it++) {
			res << "," << *it;
		}

		return res.str();
	}

	void serializeHelper(TreeNode* root, vector<string>& enStr) {
		if (root == NULL) {
			enStr.push_back(to_string(-10000));
			return;
		}

		enStr.push_back(to_string(root->val));
		serializeHelper(root->left, enStr);
		serializeHelper(root->right, enStr);
	}
	

	// Decodes your encoded data to tree.
	TreeNode* deserialize(string data) {
		string token;
		vector<int> parsedNum;
		stringstream dataStream(data);

		while (getline(dataStream, token, ',')) {
			parsedNum.push_back(stoi(token));
		}

		int idx = 0;
		return deserializeHelper(parsedNum, idx);
	}

	TreeNode* deserializeHelper(vector<int>& parsedNums, int& idx) {
		if (parsedNums[idx] == -10000) {
			return NULL;
		}

		TreeNode* newNode = new TreeNode(parsedNums[idx]);
		idx += 1;
		newNode->left = deserializeHelper(parsedNums, idx);
		idx += 1;
		newNode->right = deserializeHelper(parsedNums, idx);

		return newNode;
	}

};


int main() {

	Codec* codec = new Codec();

	TreeNode* treeNode = new TreeNode(1, new TreeNode(2, NULL, NULL), new TreeNode(3, new TreeNode(4, NULL, NULL), new TreeNode(5, NULL, NULL)));
	string s =  codec->serialize(treeNode);

	TreeNode * t = codec->deserialize(s);

	int ts = 100;


}
