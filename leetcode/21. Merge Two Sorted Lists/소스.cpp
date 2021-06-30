#include<iostream>
#include<vector>

using namespace std;

struct ListNode {
	int val;
	ListNode* next;
	ListNode() : val(0), next(nullptr) {}
	ListNode(int x) : val(x), next(nullptr) {}
	ListNode(int x, ListNode* next) : val(x), next(next) {}
};

class Solution {
public:
	ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
		ListNode newNode(0);
		ListNode* tail = &newNode;

		while (l1 && l2) {
			if (l1->val > l2->val) {
				tail->next = l2;
				l2 = l2->next;
			}
			else {
				tail->next = l1;
				l1 = l1->next;
			}
			tail = tail->next;
		}

		tail->next = l1 ? l1 : l2;

		return newNode.next;
	}
};

int main() {

}

