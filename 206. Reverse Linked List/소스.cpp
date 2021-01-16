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
	ListNode* reverseList(ListNode* head) {
		if (head == nullptr) {
			return  head;
		}
		return reverse(head, nullptr);
		
	}
private:
	ListNode* reverse(ListNode* cur, ListNode* change) {

		ListNode* nextNode = cur->next;
		cur->next = change;
		
		if (nextNode == nullptr) {
			return cur;
		}
		return reverse(nextNode, cur);

	}
};

int main() {

}