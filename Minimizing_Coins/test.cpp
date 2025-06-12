#include <bits/stdc++.h>
#include <iostream>
#include <vector>

using namespace std;

int solution(int n, int amount, vector<int>& coins) {
	vector<int> dp(amount+1, amount+1); // Initialize with a a large value (amount + 1) 
	dp[0] = 0;
	
	for (int i=1; i <= amount; ++i) {
		for (int coin : coins) {
			if (i - coin >= 0) {
				dp[i] = min(dp[i], dp[i-coin] + 1);
			}
		}
	}
	
	return (dp[amount] == amount + 1) ? - 1 : dp[amount];
}

int main() {
	int n, x;
	cin >> n >> x;
	vector<int> coins(n);
	
	for (int i=0; i<n; i++) {
		cin >> coins[i];
	}
	
	int result = solution(n, x, coins);
	cout << result << endl;
	
	return 0;
}