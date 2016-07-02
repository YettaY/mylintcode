/*************************************************************************
	> File Name: pr_a.cpp
	> Author: dragon007
	> Mail: wanglong.wu@vipl.ict.ac.cn
	> Created Time: 2016年06月26日 星期日 13时05分36秒
 ************************************************************************/

#include <iostream>
#include <string>
#include <map>
#include <algorithm>
#include <cstdio>

using namespace std;

typedef long long LL;

#define MOD 1000000007

int T;

int main() {
  freopen("input.txt", "r", stdin);
  cin>>T;
  for (int ca = 1; ca <= T; ++ ca) {
    string s;
    cin>>s;
    LL ans = 1;
    int cnt[26];
    for (int i = 0; i < 26; ++ i) cnt[i] = 0;
    for (int i = 0; i < s.size(); ++ i) {
      LL c = 0;
      for (int j = max(i - 1, 0); j < min((int)s.size(), i + 2); ++ j) {
        if (cnt[s[j] - 'a'] == 0) c ++ ;
        cnt[s[j] - 'a'] ++ ;
      }
      ans = ans * c % MOD;
      for (int j = max(i - 1, 0); j < min((int)s.size(), i + 2); ++ j) {
        cnt[s[j] - 'a'] -- ;
      }
    }
    cout << "Case #" << ca << ": " << ans << endl;
  }
  return 0;
}
