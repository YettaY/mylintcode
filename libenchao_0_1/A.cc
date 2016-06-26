#include <iostream>
#include <string>
using namespace std;

const long long mod = 1000000007;

int main() {
    int T;
    cin >> T;
    for (int t = 1; t <= T; ++t) {
        cout << "Case #" << t << ": ";
        string s;
        cin >> s;
        int n = s.size();
        long long ans = 1;
        for (int i = 1; i < n-1; ++i) {
            int cnt = 1;
            if (s[i] != s[i-1]) cnt++;
            if (s[i+1] != s[i] && s[i+1] != s[i-1]) cnt++;
            ans *= cnt;
            ans %= mod;
        }
        if (n > 1 && s[0] != s[1]) ans *= 2;
        if (n > 1 && s[n-1] != s[n-2]) ans *= 2;
        ans %= mod;
        cout << ans << endl;
    }
    return 0;
}
