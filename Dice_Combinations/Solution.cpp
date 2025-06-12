#include <iostream>
#include <vector>
using namespace std;

const int MOD = 1e9+7;

// Main function
int main() {
	/*
		Your task is to count the number of ways to construct sum n by throwing a dice
		one or more times. Each throw produces an outcome between 1 and 6. 
		
		For example, if n = 3, there are 4 ways:
		- 1 + 1 + 1
		- 1 + 2
		- 2 + 1
		- 3
		
		Input 
		- The only input line has an integer n.
		
		Output 
		- Print the number of ways modulo 10 ^ 9 + 7.
		
		Constraints 
		- 1 <= n <= 10^6
		
		Example:
		Input:
		3
		Output:
		4
	*/
	
	/*
		idea here is to create a dp of size n. and iterating from current to last 6 until its greater than 0, and sum it up.
	*/
	
	long long n = 0;
	cin >> n;
	
	if (n == 0) {
		cout << 0 << endl;
		return 0;
	}
	
	vector<long long> dp(n+1);
	dp[0] = 1;
	
	for (int i=1; i<=n; i++) {
		long long current = 0;
		for (int j=1; j<=6 && i-j>=0; j++) {
			current = (current + dp[i-j]) % MOD;
		}
		dp[i] = current; 
	}
	
	cout << dp[n] << endl;
	return 0; 
}