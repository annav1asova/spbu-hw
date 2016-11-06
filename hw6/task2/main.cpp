#include <iostream>

using namespace std;

void toBin(int array[], int a)
{
    int bit = 0b10000000;
    for (int j = 0; j < 8; ++j)
    {
        if (a & bit)
            array[j] = 1;
        else
            array[j] = 0;
        bit = bit >> 1;
    }
}

int sum(int arrayA[], int arrayB[], int result[])
{
    int mind = 0;
    for (int i = 7; i >= 0; i--)
    {
        int temp = arrayA[i] + arrayB[i] + mind;
        result[i] = temp % 2;
        mind = temp / 2;
    }
}

int powTwo(int a)
{
    int result = 1;
    for (int i = 0; i < a; i++)
    {
        result *= 2;
    }
    return result;
}

int toDec(int arr[])
{
    if (arr[0] == 1)
    {
        for (int i = 1; i < 8; i++)
        {
            arr[i] = 1 - arr[i];
        }
    }
    int result = 0;
    for (int i = 1; i < 8; i++)
    {
        result += powTwo(7 - i) * arr[i];
    }
    if (arr[0])
        return - result - 1;
    else
        return result;
}

int main()
{
    cout << "Введите первое число: ";
    int a = 0;
    cin >> a;

    cout << "Введите второе число: ";
    int b = 0;
    cin >> b;

    int arrayA[8] = {0};
    int arrayB[8] = {0};
    int sumArray[8] = {0};

    toBin(arrayA, a);
    toBin(arrayB, b);

    cout << "a = ";
    for (int j = 0; j < 8; ++j)
    {
        cout << arrayA[j];
    }
    cout << endl;

    cout << "b = ";
    for (int j = 0; j < 8; ++j)
    {
        cout << arrayB[j];
    }
    cout << endl;

    sum(arrayA, arrayB, sumArray);

    cout << "sum = ";
    for (int j = 0; j < 8; ++j)
    {
        cout << sumArray[j];
    }

    int result = toDec(sumArray);
    cout << " = " << result << endl;
    cout << "(в дополнительном коде)" << endl;
}
