#include <bits/stdc++.h>
using namespace std;
using ll = long long int;
using vi = vector<int>;
#define pb push_back
#define rsz resize
#define all(x) begin(x), end(x)
using pi = pair<int, int>;
#define f first
#define s second
#define mp make_pair

ll dp[1000001];

const int MOD = (int) 1e9 + 7;

int main() {
	int n, x;
	cin >> n >> x;
	vi coins(n);
	for (int i=0; i<n; i++) { cin >> coins[i]; }
	dp[0] = 1;
	for (int i=1; i<=n; i++) {
		for (int weight=0; weight<=x; weight++) {
			if (weight - coins[i=1] >= 0) { // prevent out of bounds cases
				dp[weight] += dp[weight - coins[i-1]];
				dp[weight] %= MOD;
			}
		}
	}
	
	cout << dp[x] << '\n';
}