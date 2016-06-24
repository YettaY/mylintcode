//============================================================================
// Name        : CF.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <bits/stdc++.h>
#define  RD(x)      scanf("%d", &x)
#define  REP(i, n)  for (int i=0; i<int(n); ++i)
#define  FOR(i, n)  for (int i=1; i<=int(n); ++i)
#define  pii        pair<int, int>
#define  piL        pair<int, long long>
#define  mp         make_pair
#define  pb         push_back
#define  whatis(x)  cout << #x << ": " << x << endl;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
using namespace std;
#define  N   12345
#define  eps 1e-13
#define  pi  acos(-1.0)
#define  inf 0XFFFFFll
#define  mod 1000000007ll
#define  LL  long long
#define  ULL unsigned long long

struct Edge {
	int v, cost[24];
};
vector<Edge> node[N];
int n, m, K;

int dist[N][24];
bool inq[N][24];
void spfa() {
	memset(dist, -1, sizeof dist);
	memset(inq, false, sizeof inq);

	queue<pii> que;
	REP(h, 24) {
		que.push({1, h});
		dist[1][h] = 0;
		inq[1][h] = true;
	}

	while (!que.empty()) {
		int u = que.front().first;
		int h = que.front().second;
		que.pop();
		inq[u][h] = false;
		for (Edge &e : node[u]) {
			int v = e.v;
			int cost = dist[u][h] + e.cost[(h + dist[u][h]) % 24];
			if (cost < dist[v][h] || dist[v][h] == -1) {
				dist[v][h] = cost;
				if (!inq[v][h]) {
					inq[v][h] = true;
					que.push({v, h});
				}
			}
		}
	}
}

int Main() {

	freopen("A-small-attempt0.in", "r", stdin);
	freopen("out.txt", "w", stdout);
	ios_base::sync_with_stdio(0);
	int T; cin >> T;

	FOR(_T, T) {
		cout << "Case #" << _T << ": ";

		cin >> n >> m >> K;
		FOR(i, n)
			node[i].clear();
		REP(_m, m) {
			int x, y; cin >> x >> y;
			Edge e;
			REP(h, 24)
				cin >> e.cost[h];
			e.v = y;
			node[x].push_back(e);
			e.v = x;
			node[y].push_back(e);
		}

		spfa();

		REP(k, K) {
			int d, s; cin >> d >> s;
			cout << dist[d][s];
			if (k == K - 1)
				cout << endl;
			else
				cout << " ";
		}

	}


	return 0;
}

int main() {
	return Main();
}
