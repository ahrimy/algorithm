#include <iostream>
#include <math.h>

using namespace std;

int main()
{
    int t;
    int x1,y1,r1,x2,y2,r2;
    float* a; float* b; float* d;
    
    scanf("%d",&t);
    a = new float[t];
    b = new float[t];
    d = new float[t];
    for(int i=0;i<t;i++){
        do{
            scanf("%i%i%d%i%i%d",&x1,&y1,&r1,&x2,&y2,&r2);
        }while(x1<-10000||x1>10000||y1<-10000||y1>10000||r1<=0||r1>10000||x2<-10000||x2>10000||y2<-10000||y2>10000||r2<=0||r2>10000);
    d[i] = sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    if(r2>r1){a[i]=r2;b[i]=r1;}
    else{a[i]=r1;b[i]=r2;}
    
    }
    
    for(int i=0;i<t;i++){
        if(a[i]-b[i]>d[i]||a[i]+b[i]<d[i]) printf("0\n");
        else if(a[i]+b[i]>d[i]&&d[i]>a[i]-b[i]) printf("2\n");
        else{
            if(d[i]==0&&a[i]==b[i])printf("-1\n");
            else printf("1\n");
        } 
    }
    delete[] a;
    delete[] b;
    delete[] d;
    return 0;
}

