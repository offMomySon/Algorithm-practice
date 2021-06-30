#include<iostream>
#include<vector>
#include<unordered_map>
#include<algorithm>
#include<queue>

using namespace std;


class Solution {
public:
	int leastInterval(vector<char>& tasks, int n) {
		unordered_map<char, int>mp;
		int count = 0;
		for (auto e : tasks)
		{
			mp[e]++;
			count = max(count, mp[e]);
		}

		int ans = (count - 1) * (n + 1);
		for (auto e : mp) if (e.second == count) ans++;
		return max((int)tasks.size(), ans);
	}
};

//class Solution {
//public:
//	int leastInterval(vector<char>& tasks, int n) {
//		unordered_map<char, int> counts;
//		for (char t : tasks) {
//			counts[t]++;
//		}
//		priority_queue<pair<int, char>> pq;
//		for (pair<char, int> count : counts) {
//			pq.push(make_pair(count.second, count.first));
//		}
//		int alltime = 0;
//		int cycle = n + 1;
//		while (!pq.empty()) {
//			int time = 0;
//			vector<pair<int, char>> tmp;
//			for (int i = 0; i < cycle; i++) {
//				if (!pq.empty()) {
//					tmp.push_back(pq.top());
//					pq.pop();
//					time++;
//				}
//			}
//			for (auto t : tmp) {
//				if (--t.first) {
//					pq.push(t);
//				}
//			}
//			alltime += !pq.empty() ? cycle : time;
//		}
//		return alltime;
//	}
//};


int main() {
	Solution* s = new Solution();

	//vector<char> vec({ 'A','A','A','B','B','B' });
	//cout << s->leastInterval(vec, 0);

	//vector<char> vec({ 'A','A','A','B','B','B' });
	//cout << s->leastInterval(vec, 2);

	//ABC ABC
	& !AB ACA
	vector<char> vec({ 'A','A','A','A','A','B','B','B','C','C','C' });
	cout << s->leastInterval(vec, 1);
}

// ABABAC C
