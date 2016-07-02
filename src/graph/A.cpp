#include <iostream>
#include <cstdio>
#include <vector>
#include <cstring>
#include <algorithm>
#include <queue>
#define x first
#define y second
using namespace std;
const int INF = (int)1e9;
struct Point {
	int city;
	int cost[24];
};
vector <Point> E[510];
int T;
int n, m, q;
int d[510][24], inque[510][24], ans[24][510];
queue < pair<int, int> > que;
void spfa( int t ) {
	for ( int i = 1; i <= n; i ++ ) {
		for ( int j = 0; j < 24; j ++ )	{
			d[i][j] = INF;
		}
	}
	que.push( make_pair( 1, t ) );
	inque[1][t] = 1;
	d[1][t] = 0;

	while ( !que.empty() ) {
		pair <int, int>	cur = que.front();
		que.pop();
		int u = cur.x, t = cur.y;
		inque[u][t] = false;
				
		for ( int i = 0; i < (int)E[u].size(); i ++ ) {
			int v = E[u][i].city, val = E[u][i].cost[t];
			int nxtT = (t + val) % 24;

			if ( d[u][t] + val < d[v][nxtT] ) {
				d[v][nxtT] = d[u][t] + val;

				if ( !inque[v][nxtT] ) {
					inque[v][nxtT] = true;
					que.push( make_pair( v, nxtT ) );
				}
			}
		}
	}

	for ( int i = 1; i <= n; i ++ ) {
		ans[t][i] = INF;
		for ( int j = 0; j < 24; j ++ ) {
			ans[t][i] = min( ans[t][i], d[i][j] );
		}
	}
}

int main() {
	freopen( "A.in", "r", stdin );
	freopen( "A.out", "w", stdout );
	int T;
	scanf( "%d", &T );
	for ( int cas = 1; cas <= T; cas ++ ) {
		scanf( "%d%d%d", &n, &m, &q );
		for ( int i = 1; i <= n; i ++ ) {
			E[i].clear();
		}
		for ( int i = 0; i < m; i ++ ) {
			int a, b;
			scanf( "%d%d", &a, &b );
			Point p;
			for ( int i = 0; i < 24; i ++ )	{
				scanf( "%d", &p.cost[i] );
			}
			p.city = b;
			E[a].push_back( p );
			p.city = a;
			E[b].push_back( p );
		}

		for ( int i = 0; i < 24; i ++ )	{
			spfa( i );
		}

		printf( "Case #%d:", cas );
		while ( q -- ) {
			int a, b;
			scanf( "%d%d", &a, &b );
			int ret = ( ans[b][a] == INF ) ? -1 : ans[b][a];
			printf( " %d", ret );
		}
		printf( "\n" );
	}


	return 0;	
}










