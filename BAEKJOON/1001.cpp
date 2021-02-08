#include <iostream>

using namespace std;

int main()
{
    int a,b,c;
    do{
        scanf("%d%d",&a,&b);
    }while(a<=0||a>=10||b<=0||b>=10);
    c = a+b;
    printf("%d",c);
    return 0;
}
