#include<iostream>
#include<vector>

using namespace std;

 
struct ListNode {
     int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
};
 
class Solution {
public:
	ListNode* detectCycle(ListNode* head) {

		ListNode* fast = head;
		ListNode* slow = head;

		while (fast != NULL && fast->next != NULL) {

			fast = fast->next->next;
			slow = slow->next;
			if (fast == slow) {
				break;
			}
		}
		// I = r + a
		// 2I = r + a + b + a
		// r = b
		if (fast == NULL || fast->next == NULL) return NULL;

		fast = head;
		while (slow != fast) {
			fast = fast->next;
			slow = slow->next;
		}
		return fast;
	}
};

int main() {

}