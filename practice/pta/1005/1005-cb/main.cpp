#include <iostream>

using namespace std;

int main()
{

    // ��ȡ���루list��
    // ������ֵ
    // �Ƚ���ֵ��ѭ����
    // �������ݣ�ѭ����
    // ����δ���������
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
