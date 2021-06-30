#include<iostream>
#include<vector>
#include<unordered_map>

using namespace std;

class Node {
public:
	int val;
	Node* next;
	Node* random;

	Node(int _val) {
		val = _val;
		next = NULL;
		random = NULL;
	}
};


class Solution {
public:
	Node* copyRandomList(Node* head) {
		unordered_map<Node*, int> origin_map;
		unordered_map<int, Node*> copy_map;

		Node* dummy = new Node(0);
		Node* prev = dummy;
		Node* tempHead = head;

		int idx = 0;
		while (tempHead != NULL) {
			Node* newNode = new Node(tempHead->val);
		
			prev->next = newNode;
			prev = prev->next;

			origin_map[tempHead] = idx;
			copy_map[idx] = newNode;

			tempHead = tempHead->next;
			idx++;
		}

		tempHead = head;
		prev = dummy->next;
		while (tempHead != NULL) {
			if (tempHead->random == NULL) {
				prev->random = NULL;
			}
			else {
				prev->random = copy_map[origin_map[tempHead->random]];
			}

			prev = prev->next;
			tempHead = tempHead->next;
		}


		Node* res = dummy->next;

		return res;
	}
};

int main() {

}