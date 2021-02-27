#include<iostream>
#include<vector>
#include<numeric>
#include <algorithm>

//��¥ - 2021/02/27
//���� - 12:33
//���� - 02:30
//�Ǽ� - ��¥�� �������� binary serarch �����ѵ� ��� ����� �������� �׽�Ʈ �Ѵٴ°��� �������� ���ߴ�.
//       ��¥�� Ŀ���� Ŀ������ �ݵ�� true �� �ȴ�. �׷��� ������ binary search ����� ����� ���ִ�.
//���� - 

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