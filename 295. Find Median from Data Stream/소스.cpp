#include<vector>
#include<iostream>
#include<queue>

using namespace std;

class compDec {
public:
	int operator()(int a, int b) {
		return a > b;
	}
};

class compAsc {
public:
	int operator()(int a, int b) {
		return a < b;
	}
};

class MedianFinder {
public:
	/** initialize your data structure here. */
	int size;
	priority_queue<int, vector<int>, compDec> min_queue;
	priority_queue<int, vector<int>, compAsc> max_queue;

	MedianFinder() {
		
	}

	void addNum(int num) {
		if (max_queue.empty()) {
			return max_queue.push(num);
		}

		if (max_queue.top() > num) {
			max_queue.push(num);
		}
		else {
			min_queue.push(num);
		}

		if (max_queue.size() > min_queue.size() + 1) {
			min_queue.push(max_queue.top());
			max_queue.pop();
		}
		else if (min_queue.size() > max_queue.size() +1) {
			max_queue.push(min_queue.top());
			min_queue.pop();
		}
	}

	double findMedian() {
		if (max_queue.size() == min_queue.size())
			return max_queue.empty() ? 0 : (max_queue.top() + min_queue.top()) / 2.0;
		
		if (max_queue.size() > min_queue.size())
			return max_queue.top();
		else
			return min_queue.top();
	}
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */

int main() {
	MedianFinder* s = new MedianFinder();

	s->addNum(6);
	cout << s->findMedian() << endl;
	s->addNum(10);
	cout << s->findMedian() << endl;
	s->addNum(2);
	cout << s->findMedian() << endl;
	s->addNum(6);
	cout << s->findMedian() << endl;
} 