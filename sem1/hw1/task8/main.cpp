#include <iostream>

using namespace std;
int recursiveFactorial(int n)
{
    if (n == 1)
    {
        return 1;
    }
    else
    {
        return n * recursiveFactorial(n - 1);
    }
    
}

int iterativeFactorial(int n)
{
    int res = 1;
    for (int i = 1; i <= n; i++)
    {
        res = res * i;
    }
    return res;
    
}
int main()
{
    int n = 0;
    cout << "Введите число n: ";
    cin >> n;
    int firstResult = iterativeFactorial(n);
    int secondResult = recursiveFactorial(n);
    cout << "Факториал числа n итеративным способом: " << firstResult << endl;
    cout << "Факториал числа n рекурсивным способом: " << secondResult << endl;
    return 0;
}
