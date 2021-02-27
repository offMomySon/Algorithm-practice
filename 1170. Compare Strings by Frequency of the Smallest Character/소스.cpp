#include<iostream>
#include<vector>
#include<string>
#include<algorithm>

//날짜 - 2021/02/27
//시작 - 17:30
//종료 - 18:30
//실수 - 1) dp 를 써서 풀어도 가능함.
//       2) words 의 count 를 구하고 sort 한뒤,
//          count 의 size 만큼 빼는 것은 생각해보지 않음.
//참조 - 

using namespace std;

class Solution {
public:
    static bool cmp(int a, int b) {
        return a < b;
    }

    vector<int> numSmallerByFrequency(vector<string>& queries, vector<string>& words) {
        vector<int> queryCounts;
        vector<int> wordCounts;

        for (auto query : queries) {
            queryCounts.push_back(countFrequence(query));
        }
        for (auto word : words) {
            wordCounts.push_back(countFrequence(word));
        }

        sort(wordCounts.begin(), wordCounts.end(), cmp);
        vector<int> res;

        for (auto queryCount : queryCounts) {
            //res.push_back(wordCounts.size() - my_upper_bound(wordCounts, 0, wordCounts.size() - 1, queryCount));
            res.push_back(wordCounts.size() - (upper_bound(wordCounts.begin(), wordCounts.end(), queryCount) - wordCounts.begin()));
        }

        return res;
    }

    int my_upper_bound(vector<int>& wordCounts, int start, int end, int key) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (wordCounts[mid] <= key) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return start;
    }



    int countFrequence(string &str) {
        vector<int> chCount(26,0);
        for (auto ch : str) {
            chCount[ch - 'a'] ++;
        }

        int res = 0;
        for (auto num : chCount) {
            if (num != 0) {
                res = num;
                break;
            }
        }
        return res;
    }

};

int main() {
    Solution* s = new Solution();

    vector<string> queries({ "bbb","cc" });
    vector<string> words({ "a","aa","aaa","aaaa" });

    vector<int> res = s->numSmallerByFrequency(queries, words);

    for (auto r : res) {
        cout << r << " ";
    }

}