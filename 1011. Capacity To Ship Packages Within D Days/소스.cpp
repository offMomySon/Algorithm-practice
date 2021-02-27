#include<iostream>
#include<vector>
#include<numeric>
#include <algorithm>

//��¥ - 2021/02/27
//���� - 12:00
//���� - 13:10
//�Ǽ� - lower bound �̼�. arr �� �� idx ���� ���ʺ��� �����ѵ� capacity �� ���ؾ� �Ѵٰ� ��������.
//���� - 

using namespace std;

class Solution {
public:
    int shipWithinDays(vector<int>& weights, int D) {
        auto end = accumulate(weights.begin(), weights.end(), 0);
        auto start = max( end / D, *max_element(weights.begin(), weights.end()));
        
        while (start <= end) {
            int mid = (start + end) / 2;

            if ( count(weights, mid)<= D) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }

    int count(vector<int>& weights, int capacity) {
        int cur_cap = 0;
        int count = 1;

        for (auto weight : weights) {
            cur_cap += weight;
            if (cur_cap > capacity) {
                count++;
                cur_cap = weight;
            }
        }   
        return count;
    }
};

int main() {

    Solution* s = new Solution();

    vector<int> vec({ 1,2,3,4,5,6,7,8,9,10 });

    cout << s->shipWithinDays(vec,5);

}