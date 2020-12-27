/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <stdio.h>

#define MAX 9

int arr[MAX];
bool selected[MAX];
int sum = 0;
int dwarf[7];

void Print(){
   int temp=0;
    for(int i=0;i<6;i++){
        for(int j=0;j<6-i;j++){
            if(dwarf[j]>dwarf[j+1]){
              temp = dwarf[j];
              dwarf[j] = dwarf[j+1];
              dwarf[j+1]=temp;
            }
        }
    }
    for(int i=0;i<7;i++){
        printf("%d\n",dwarf[i]);
    }
}
void DFS(int Idx,int Cnt){
    if(sum==100){
        return;
    }
    if(Cnt==7){
        sum=0;
        int j=0;
        for(int i=0;i<MAX;i++){
            if(selected[i]==true){
                sum = sum+arr[i];
                dwarf[j++]=arr[i];
            }
        }
        if(sum==100){
            Print();
        }
        return;
    }
    for(int i=Idx;i<MAX;i++){
        if(selected[i]==true)continue;
        selected[i]=true;
        DFS(i,Cnt+1);
        selected[i]=false;
    }
}

int main()
{
    for(int i=0;i<9;i++){
        scanf("%d",&arr[i]);
    }
    DFS(0,0);

    return 0;
}
