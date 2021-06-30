#include<iostream>
#include<vector>
#include<stack>
#include<utility>

using namespace std;

class Solution {
public:
	vector<int> dailyTemperatures(vector<int>& T) {
		vector<int> res(T.size());
		stack<int> st;

		for (int i = T.size() - 1; i >= 0; i--) {
			while (true) {
				if (st.empty()) {
					res[i] = 0;
					st.push(i);
					break;
				}

				if (T[st.top()] > T[i]) {
					res[i] = st.top() - i;
					st.push(i);
					break;
				}

				st.pop();
			}
		}

		return res;
	}
};

int main() {
	Solution* s = new Solution();

	vector<int>test = { 73, 74, 75, 71, 69, 72, 76, 73 };
	vector<int> res = s->dailyTemperatures(test);

	for (auto it = res.begin(); it != res.end(); it++) {
		cout << *it << " ";
	}
}


