#include <iostream>
#include <algorithm>
using namespace std;

int n;
char color[51][51];
char copi[51][51];

//int dx[] = {-1, 1, 0, 0};
//int dy[] = {0, 0, -1, 1};

int go() {
	int res = 1;

	for (int i = 0; i < n; i++) {
		int temp = 1;

		for (int j = 1; j < n; j++) {
			if (color[j][i] == color[j - 1][i])
				temp++;

			else
				temp = 1;

			if (res < temp)
				res = temp;
		}
        
        temp=1;

		for (int j = 1; j < n; j++) {
			if (color[i][j] == color[i][j - 1])
				temp++;

			else
				temp = 1;

			if (res < temp)
				res = temp;
		}
	}

	return res;
}

int main()
{
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		getchar();
		for (int j = 0; j < n; j++) {
			scanf("%c", &color[i][j]);
			copi[i][j] = color[i][j];
		}
	}

	int ans = 1;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (i + 1 < n) {
				swap(color[i][j], color[i + 1][j]);
				int temp = go();
		//		cout << go() << " ";
				if (ans < temp)
					ans = temp;
				swap(color[i][j], color[i + 1][j]);
			}

			if (j + 1 < n) {
				swap(color[i][j], color[i][j+1]);
				int temp = go();
		//		cout << go() << " ";
				if (ans < temp)
					ans = temp;
				swap(color[i][j], color[i][j+1]);
			}
		}
	//	cout << '\n';
	}

	cout << ans << '\n';

    return 0;
}