#include <iostream>

using namespace std;

int main()
{

    // 读取输入（list）
    // 计算数值
    // 比较数值（循环）
    // 存入数据（循环）
    // 查找未存入的数据
    return 0;
}

int oddCalculate(int odd);
int evenCalculate(int even);
int calculate(int num)
{
    int result;
    if(num % 2 == 0){result = evenCalculate(num);}
    else{result = oddCalculate(num);}
    return reslut;
}

int oddCalculate(int odd)
{
    return (odd*3+1)/2;
}

itn evenCalculate(int even)
{
    return even/2;
}
