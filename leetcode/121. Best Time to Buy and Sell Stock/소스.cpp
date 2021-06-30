#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class Solution {
public:
	int maxProfit(vector<int>& prices) {
		if (prices.size() == 0) {
			return 0;
		}
		int maxValue = prices[prices.size()-1];
		int maxProfit = 0;
	
		for (int i = prices.size() - 1; i >= 0; i--)
		{
			int price = prices[i];

			if (maxValue == price) {
				continue;
			}
			if (maxValue < price) {
				maxValue = price;
				continue;
			}
			maxProfit = max(maxProfit, maxValue - price);
		}

		return maxProfit;
	}
};

int main() {


}