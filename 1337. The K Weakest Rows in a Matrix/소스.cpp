#include<iostream>
#include<vector>
#include<unordered_map>
#include<algorithm>

using namespace std;

//날짜 - 2021/02/24
//시작 - 02:00
//종료 - 02:30
//실수 - 문법적오류. sort 에 cmp 추가X, 
//참조 - None.

class Solution {
public:

	static bool cmp(pair<int, int> a, pair<int, int> b) {
		if (a.second < b.second)
			return true;
		if (a.second == b.second) 
			return a.first < b.first;
		return false;
	}

	vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
		vector<pair<int, int>> m;

		for (int i = 0; i < mat.size(); i++) {
			m.push_back(make_pair(i,upper_bound(mat[i], 0, mat[i].size() - 1)) );
		}

		sort(m.begin() , m.end(), cmp);

		vector<int> res;
		for (int i = 0; i < k; i++) {
			res.push_back(m[i].first);
		}
		return res;
	}

	int upper_bound(vector<int>& mat, int start, int end) {
		if (start > end)
			return start;

		int mid = (start + end) / 2;
		if (mat[mid] >= 1) {
			return upper_bound(mat, mid + 1, end);
		}
		else {
			return upper_bound(mat, start, mid-1);
		}
	}
};

int main() {
	Solution* s = new Solution();

	vector<vector<int>> vec = { {1, 0, 0, 0},{1, 1, 1, 1 },{1, 0, 0, 0},{1, 0, 0, 0} };
	int k = 2;
	vector<int> res = s->kWeakestRows(vec, k);

	for (auto it = res.begin(); it != res.end(); it++) {
		cout << *it << endl;
	}
}