#include<iostream>
#include<vector>
#include<numeric>
#include <algorithm>

//날짜 - 2021/02/27
//시작 - 12:33
//종료 - 02:30
//실수 - 날짜를 기준으로 binary serarch 선택한뒤 모든 경우의 수에대해 테스트 한다는것을 생각하지 못했다.
//       날짜가 커지면 커질수록 반드시 true 가 된다. 그렇기 때문에 binary search 방법을 사용할 수있다.
//참조 - 

using namespace std;

class Solution {
public:
    int minDays(vector<int>& bloomDay, int m, int k) {
        int n = bloomDay.size(), minNum = 1, maxNum = 1e9;
        if (n < m * k)
            return -1;

        while (minNum < maxNum) {
            int midNum = (minNum + maxNum) / 2, bouquet = 0, adjSeq = 0;

            for (int i = 0; i < n; i++) {
                if (bloomDay[i] > midNum) {
                    adjSeq = 0;
                }
                else if (++adjSeq >= k) {
                    bouquet++;
                    adjSeq = 0;
                }
            }

            if (bouquet<m) {
                minNum = midNum + 1;
            }
            else {
                maxNum = midNum;
            }
        }

        return minNum;
    }

};


int main() {
    Solution* s = new Solution();

    //vector<int> v({ 1,10,2,9,3,8,4,7,5,6 });
    vector<int> v({ 1000000000,1000000000 });

    cout << s->minDays(v, 1, 1);

}