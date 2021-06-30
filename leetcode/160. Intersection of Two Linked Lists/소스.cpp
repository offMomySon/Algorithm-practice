#include<iostream>
#include<vector>

using namespace std;

struct ListNode {
	int val;
	ListNode* next;
	ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
	ListNode* getIntersectionNode(ListNode* headA, ListNode* headB) {
		if (headA == NULL || headB == NULL)
			return NULL;

		ListNode* tHeadA = headA;
		ListNode* tHeadB = headB;

		while (tHeadA != tHeadB) {
			
			tHeadA = tHeadA==NULL?headB:tHeadA->next;
			tHeadB = tHeadB == NULL ? headA : tHeadB->next;

			

		}

		return tHeadA;
	}



};

int main() {

	
}

