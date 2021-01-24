#include<iostream>
#include<vector>
#include<queue>

using namespace std;

struct ListNode {
      int val;
      ListNode *next;
      ListNode() : val(0), next(nullptr) {}
      ListNode(int x) : val(x), next(nullptr) {}
      ListNode(int x, ListNode *next) : val(x), next(next) {}
 };
 
class Solution {
	struct cmp
	{
		bool operator()(ListNode* left, ListNode* right) {
			return left->val > right->val;
		}
	};
public:
	ListNode* mergeKLists(vector<ListNode*>& lists) {
		if (lists.size() == 0) return NULL;

		priority_queue<ListNode*, vector<ListNode*>, cmp> pq;
		for (auto list : lists) {
			if(list != NULL) pq.push(list);
		}

		if (pq.empty()) return NULL;

		ListNode* dummy = new ListNode(0);
		ListNode* res = dummy;
		while (!pq.empty()) {
			dummy->next = pq.top();
			pq.pop();

			dummy = dummy->next;
			if (dummy->next != NULL)
				pq.push(dummy->next);
		}

		return res->next;
	}
};














