#include <iostream>

using namespace std;
int gcd(double a, double b)
{
    while (a != b)
    {
        if (a > b)
        {
            a -= b;
        }
        else
        {
            b -= a;
        }
    }
    return a;
}

void outputArrays(double firstArray[], double secondArray[], int size)
{
    cout << "Дроби: ";
    for (int i = 0; i < size; i++)
    {
        cout << firstArray[i] << "/" << secondArray[i] << " ";
    }
    cout << endl;
}

void initialization(double array[], double size)
{
    for (int i = 0; i < size; i++)
    {
        array[i] = 0;
    }
}

void swap (double *a, double *b)
{
    double t = *a;
    *a = *b;
    *b = t;
}

void qsort(double firstArray[], double secondArray[], int left, int right)
{
    int i = left;
    int j = right;
    double x = firstArray[left] / secondArray[left];
    while (i <= j)
    {
        while (i <= right && firstArray[i] / secondArray[i] < x)
        {
            i++;
        }
        while (firstArray[j] / secondArray[j] > x)
        {
            j--;
        }
        if (i <= j)
        {
            swap(firstArray[i], firstArray[j]);
            swap(secondArray[i], secondArray[j]);
            i++;
            j--;
        }
    }
    if (i < right)
    {
        qsort(firstArray, secondArray, i, right);
    }
    if (j > left)
    {
        qsort(firstArray, secondArray, left, j);
    }
}

int main()
{
    int n = 0;
    cout << "Введите n: ";
    cin >> n;
    int size = n * (n + 1) / 2;
    
    double *numerator = new double[size];
    initialization(numerator, size);
    double *denominator = new double[size];
    initialization(denominator, size);
    
    int realSize = 0;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            if (gcd(i, j) == 1 && i < j)
            {
                numerator[realSize] = i;
                denominator[realSize] = j;
                realSize++;
            }
        }
    }
    
    qsort(numerator, denominator, 0, realSize - 1);
    outputArrays(numerator, denominator, realSize);
    delete [] numerator;
    delete [] denominator;
    return 0;
}
