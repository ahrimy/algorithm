#include <iostream>

using namespace std;

int explore(int r,int c,int m,int n,int (&g)[50][50]){
    if(g[r][c]==1){
        g[r][c]=2;
        if(r>0&&g[r-1][c]!=2){
            explore(r-1,c,m,n,g);
        }
        if(c>0&&g[r][c-1]!=2){
            explore(r,c-1,m,n,g);
        }
        if(r+1<n&&g[r+1][c]!=2){
            explore(r+1,c,m,n,g);
        }
        if(c+1<m&&g[r][c+1]!=2){
            explore(r,c+1,m,n,g);
        }
    }

    return 0;
}
int main()
{
    int t;
    int m,n,k;
    int ground[50][50] = {0,0,};
    int x,y;
    int count;
    scanf("%d",&t);
    for(int i=0; i<t;i++){
        count = 0;
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                 ground[r][c]=0;
            }
        }
        scanf("%d%d%d",&m,&n,&k);
        for(int ii = 0;ii<k;ii++){
            scanf("%i%i",&x,&y);
            ground[y][x] = 1;
        }

        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(ground[r][c]==1){
                    count++;
                    explore(r,c,m,n,ground);
                }
            }
        }
        

         printf("%i\n",count);
    }

    return 0;
}
