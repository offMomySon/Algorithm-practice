#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class Solution {
public:
    int countGoodRectangles(vector<vector<int>>& rectangles) {
        
        int maxLen = 0;
        int cnt = 0;

        for (auto rectangle : rectangles) {
            int squareLen = min(rectangle[0], rectangle[1]);

            if (squareLen == maxLen) {
                cnt++;
            }else if(squareLen > maxLen){
                maxLen = squareLen;
                cnt = 1;
            }
        }

        return cnt;
    }
};

int main() {
    Solution* s = new Solution();

    vector<vector<int>> v({ {5,8},{3,9},{5,12},{16,5} });


    cout << s->countGoodRectangles(v);
}