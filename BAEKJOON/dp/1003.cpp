#include <iostream>

using namespace std;

int fibo[41] = {0,1,};

int fibonacci(int n){
    if(n<=1){
        return fibo[n];
    }
    else if(fibo[n]>0){
        return fibo[n];
        
    }else{
        fibo[n] = fibonacci(n-1)+fibonacci(n-2);
        return fibo[n];
    }
}

int main()
{
    int t;
    int n;
    scanf("%d",&t);
    for(int i=0;i<t;i++){
       do{
            scanf("%d",&n);
        }while(n<0||n>40);
        
        if(n==0){
          printf("1 0\n");
        }else{
        fibonacci(n);
        printf("%d %d\n",fibo[n-1],fibo[n]);
        }
    }
   
   return 0;
}