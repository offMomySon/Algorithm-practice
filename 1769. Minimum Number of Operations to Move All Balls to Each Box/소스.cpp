#include<iostream>
#include<vector>

using namespace std;

//날짜 - 2021/02/28
//시작 - 02:40
//종료 - 02:50
//실수 - 1) 한번에 다 계산하는것 생각못함.
//       2) 구현방법 또한 생각못해냄.
//참조 - 


class Solution {
public:
    vector<int> minOperations(string boxes) {


        vector<int> res(boxes.size(), 0);

        
        for (int i = 0, cnt =0, ops=0; i < boxes.size(); i++) {
            res[i] += ops;
            cnt += (boxes[i] == '1' ? 1: 0);
            ops += cnt;
        }

        for (int i = boxes.size() - 1, cnt = 0, ops = 0; i >= 0; i--) {
            res[i] += ops;
            cnt += (boxes[i] == '1' ? 1 : 0);
            ops += cnt;
        }

        return res;
    }
};



int main() {
    Solution* s = new Solution();
    string str = "001011";
    vector<int> v = s->minOperations(str);

    for (auto num : v) {
        cout << num << " ";
    }
}




