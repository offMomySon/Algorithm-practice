#include<iostream>
#include<vector>
#include<algorithm>
#include<string>

using namespace std;

//class Solution {
//public:
//
//	int minDistance(string word1, string word2) {
//		if (word1.length() == 0)
//			return word2.length();
//		if (word2.length() == 0)
//			return word1.length();
//
//		vector<vector<int>> cache(word1.length() + 1, vector<int>(word2.length() + 1, -1));
//
//		return match(word1, word2, 0, 0, cache);
//	}
//
//private:
//	int match(string& w1, string& w2, int i, int j, vector<vector<int>>& cache) {
//		if (w1.length() == i)
//			return w2.length() - j;
//		if (w2.length() == j)
//			return w1.length() - i;
//
//		if (cache[i][j] != -1) {
//			return cache[i][j];
//		}
//
//		if (w1.at(i) == w2.at(j)) {
//			cache[i][j] = match(w1, w2, i + 1, j + 1, cache);
//		}
//		else {
//			int insertOp = match(w1, w2, i, j + 1, cache);
//			int deleteOp = match(w1, w2, i + 1, j, cache);
//			int replaceOp = match(w1, w2, i + 1, j + 1, cache);
//
//			cache[i][j] = min(min(insertOp, deleteOp), replaceOp) + 1;
//		}
//
//		return cache[i][j];
//	}
//};


class Solution {
public:
	vector<vector<int>> cache;

	int minDistance(string word1, string word2) {
		cache = vector<vector<int>>(word1.size() + 1, vector<int>(word2.size() + 1, -1));
		return minDistanceHelpler(word1, word2, 0, 0);
	}

private:

	int endOfStringSum(string str, int i) {
		return str.length() - i;
	}

	int minDistanceHelpler(string &word1, string &word2, int i, int j) {
		if (word1.length() == i || word2.length() == j) {
			if (word1.length() == i && word2.length() == j)
				return 0;
			return (word1.length() == i) ? endOfStringSum(word2, j) : endOfStringSum(word1, i);
		}

		if (cache[i][j] != -1) {
			return cache[i][j];
		}

		if (word1[i] == word2[j]) {
			cache[i][j] = minDistanceHelpler(word1, word2, i + 1, j + 1);
		}
		else {

			int del = minDistanceHelpler(word1, word2, i + 1, j);
			int rep = minDistanceHelpler(word1, word2, i + 1, j + 1);
			int ins = minDistanceHelpler(word1, word2, i, j + 1);

			cache[i][j] = min(min(del, rep), ins) +1;
		}

		return cache[i][j];
	}
};

int main() {
	Solution* s = new  Solution();

	int res = s->minDistance("horse", "ros");
	cout << res;
}


