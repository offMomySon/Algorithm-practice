#include<iostream>

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
	ListNode* sortList(ListNode* head) {
		if (head == NULL || head->next == NULL)
			return head;

		ListNode* prev=NULL, *slow=head, *fast =head;
		while (fast != NULL && fast->next != NULL) {
			prev = slow;
			slow = slow->next;
			fast = fast->next->next;
		}
		prev->next = NULL;

		ListNode* harf1 = sortList(head);
		ListNode* harf2 = sortList(slow);


		return mergeSort(harf1, harf2);
	}

	ListNode* mergeSort(ListNode* head, ListNode* midHead) {
		ListNode* dummy = new ListNode(0);
		ListNode* temp = dummy;

		while (head != NULL && midHead != NULL ) {
			if (head->val < midHead->val) {
				temp = temp->next = head;
				head = head->next;
				continue;
			}else{
				temp = temp->next = midHead;
				midHead = midHead->next;
				continue;
			}
		}

		if (head != NULL) {
			temp->next = head;
		}

		if (midHead != NULL) {
			temp->next = midHead;
		}

		return dummy->next;
	}
};

int main() {


	ListNode* origin = new ListNode(4);
	ListNode* li = origin;
	li->next = new ListNode(2);
	li = li->next;
	li->next = new ListNode(1);
	li = li->next;
	li->next = new ListNode(3);
	

	Solution* s =new  Solution();
	s->sortList(origin);



}

