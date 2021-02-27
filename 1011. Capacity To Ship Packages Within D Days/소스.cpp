#include<iostream>
#include<vector>
#include<numeric>
#include <algorithm>

//날짜 - 2021/02/27
//시작 - 12:00
//종료 - 13:10
//실수 - lower bound 미숙. arr 의 앞 idx 부터 차례부터 분할한뒤 capacity 를 구해야 한다고 생각했음.
//참조 - 

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