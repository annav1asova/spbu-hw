#include <iostream>

using namespace std;

void initialization(int array[], int size)
{
    for (int i = 0; i < size; i++)
    {
        array[i] = 0;
    }
}

int iterativeFibonacci(int n)
{
    int fibonacciNumbers[n];
    initialization(fibonacciNumbers, n);
    fibonacciNumbers[0] = 1;
    fibonacciNumbers[1] = 1;
    for (int i = 2; i < n; i++)
    {
        fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
    }
    return fibonacciNumbers[n - 1];
}

int recursiveFibonacci(int n)
{
    if (n == 1 || n == 2)
    {
        return 1;
    }
    else
    {
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }
}

int main()
{
    int n = 0;
    cout << "Введите число n: ";
    cin >> n;
    
    cout << "n-ное число Фибоначчи итеративным способом: " << iterativeFibonacci(n) << endl;
    cout << "n-ное число Фибоначчи рекурсивным способом: " << recursiveFibonacci(n) << endl;
    
    return 0;
}
