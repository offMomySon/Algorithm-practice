#include<iostream>
#include<vector>
#include<algorithm>
#include<unordered_map>

using namespace std;

typedef struct Node {
	unordered_map<char, Node*> charMap;
	bool isFinish;
}Node;

class Trie {
public:
	Node* root;
	
	/** Initialize your data structure here. */
	Trie() {
		root = new Node{ {}, false };
	}

	/** Inserts a word into the trie. */
	void insert(string word) {
		insert(word, root, 0);
	}

	void insert(string& word, Node* curNode, int idx) {
		if (word.length() <= idx) {
			curNode->isFinish = true;
			return;
		}

		if (curNode->charMap.find(word.at(idx)) == curNode->charMap.end()) {
			curNode->charMap.insert({ word.at(idx), new Node{ {},false } });
		}

		insert(word, curNode->charMap[word.at(idx)], idx + 1);
	}

	/** Returns if the word is in the trie. */
	bool search(string word) {
		return search(word, root, 0);
	}

	bool search(string &word, Node* curNode, int idx) {
		if (word.length() <= idx) {
			return curNode->isFinish;
		}
		if (curNode->charMap.find(word.at(idx)) == curNode->charMap.end() ) {
			return false;
		}

		return search(word, curNode->charMap[word.at(idx)], idx + 1);
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	bool startsWith(string prefix) {
		return startsWith(prefix, root, 0);
	}

	bool startsWith(string &prefix, Node * curNode, int idx) {
		if (prefix.length() <= idx) {
			return true;
		}

		if (curNode->charMap.find(prefix.at(idx)) == curNode->charMap.end()) {
			return false;
		}

		return startsWith(prefix, curNode->charMap[prefix.at(idx)], idx + 1);
	}
};


int main() {
	Trie* trie = new Trie();
	trie->insert("abcd");
	

}