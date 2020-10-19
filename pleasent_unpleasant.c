# include <stdio.h>
# include <math.h>
#include <stdbool.h>
// A function to print all prime factors of a given number n
bool primeFactors(int n)
{
int i;
  int num = n;
bool flag=false;
    // Print the number of 2s that divide n
    while (n%2 == 0)
    {
        n = n/2;
flag=false;
    }
   
return calculate_loop;
}

// this function calculate the pleasant number
bool calculate_loop(int n, bool flag){
for(i=3;i<=sqrt(n);i=i+2)
    {
        // While i divides n, print i and divide n
     
    if (n>2&&n!=5&&n!=3) {

        flag=true;
    }
    else{
      printf("%d\n",num);
    }
  retun flag;
}
 
/* Driver program to test above function */
int main()
{
  int m,count=1,i;
bool value=false;
printf("Enter the upper limit\n");
scanf("%d",&m);
  printf("The Unplesant Prime Numbers till %d are:\n", m);
  printf("2\n");
  for(i=3;i<=m;i++){
  value=primeFactors(i);
   if(value==false)
   {
   count++;
   }
   else{
     continue;
   }
  }
    printf("Number of Unpleasant Prime Numbers between 1 and %d are %d", m,count);
    return 0;
} 
