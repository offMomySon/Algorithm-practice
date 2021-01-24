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
	bool isPalindrome(ListNode* head) {

		ListNode* slow = head, * fast = head;
		while (fast != NULL && fast->next != NULL) {
			slow = slow->next;
			fast = fast->next->next;
		}
		
		if (fast != NULL) {
			slow = slow->next;
		}

		slow = rsv(slow);
		fast = head;

		while (slow != NULL) {
			if (slow->val != fast->val) return false;
			slow = slow->next;
			fast = fast->next;
		}

		return true;
	}

	ListNode* rsv(ListNode* head) {
		ListNode* prev = NULL;

		while (head != NULL) {
			ListNode* temp = head->next;
			head->next = prev;
			prev = head;
			head = temp;
		}

		return prev;
	}
};

int main() {

}