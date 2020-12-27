/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

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
