#include<iostream>
#include<vector>

using namespace std;


struct ListNode {
      int val;
      ListNode *next;
      ListNode() : val(0), next(nullptr) {}
      ListNode(int x) : val(x), next(nullptr) {}
      ListNode(int x, ListNode *next) : val(x), next(next) {}
};
 

class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
		if (head == NULL) {
			return NULL;
		}

		int len = 1;
		ListNode* tail = head;
		while (tail->next != NULL) {
			tail = tail->next;
			len++;
		}
		tail->next = head;

		if (k %= len) {
			for (int i = 0; i < len - k; i++) {
				tail = tail->next;
			}
		}
		ListNode* newNode = tail->next;
		tail->next = NULL;

		return newNode;
    }
};

int main() {

}

