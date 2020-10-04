#include<stdio.h>

float percent(float basic,int perc){
  float cal_perc;
cal_perc=(perc*basic*10)/100;
return cal_perc;
}

//this function calculate gross salary of employee
void calculate_salary(float basic,float gross_salary, float net_salary){
  if(1<=basic<=5000000){
    printf("%f\n",basic);
gross_salary=basic+percent(basic,50)+percent(basic,10);
}

else if(500001<=basic<=1000000){
gross_salary=basic+percent(basic,60)+percent(basic,20);
}
else if(1000000<basic<=1500000){
gross_salary=basic+percent(basic,70)+percent(basic,25);
   printf("%f\n",gross_salary);
}
else{
gross_salary=basic+percent(basic,30)+percent(basic,80);
}
printf("Gross salary of an employee is %f\n",gross_salary);
printf("Enter the amount you want to donate to PM care fund in percent\n");
scanf("%d",&perc);
net_salary=gross_salary-(gross_salary*perc/100);
printf("Net salary of employee after donating to PM care fund is: %f",net_salary);
}

int main(){
int perc;
float basic,gross_salary,net_salary;
printf("Enter the basic salary of the employee\n");
scanf("%f",&basic);
calculate_salary(basic,gross_salary,net_salary);
return 0;
}
