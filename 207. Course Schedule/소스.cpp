#include<iostream>
#include<vector>
#include<queue>

using namespace std;

class Solution {
public:
	bool canFinish(int numCourses, vector<vector<int>>& pq) {
		if (pq.empty())
			return false;

		vector<vector<int>> adj(numCourses, vector<int>());
		vector<int> incoming(numCourses, 0);
		vector<int> res;

		for( auto it = pq.begin() ; it != pq.end() ; it++){
			++incoming[(*it)[0]];
			adj[(*it)[1]].push_back((*it)[0]);
		}

		queue<int> q;
		for(int i =0 ;i< numCourses ; i++){
			if (incoming[i] == 0) {
				q.push(i);
			}
		}

		//for (int i = 1; i < numCourses; i++) 
		while(!q.empty()){
			int curCource = q.front();
			res.push_back(curCource);
			q.pop();

			for (int dir = 0; dir < adj[curCource].size(); dir++) {
				--incoming[adj[curCource][dir]];
				if (incoming[adj[curCource][dir]] == 0) {
					q.push(adj[curCource][dir]);
				}
			}
		}

		if (res.size() != numCourses) return false;

		return true;
	}
};

int main() {
	Solution* s = new Solution();

	//vector<vector<int>> vec({ {1, 0},{0, 1} });
	//int m = 2;

	vector<vector<int>> vec({ {1, 0} });
	int m = 2;

	cout << s->canFinish(2, vec) << endl;
}







