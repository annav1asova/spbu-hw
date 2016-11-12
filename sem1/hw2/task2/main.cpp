#include <iostream>

using namespace std;
void inputArray(int array[], int size)
{
    cout <<  "Введите массив: ";
    for ( int i = 0; i < size; i++)
    {
        cin >> array[i];
    }
}

void outputArray(int array[], int size)
{
    cout << "Отсортированный массив: ";
    for (int i = 0; i < size; i++)
    {
        cout << array[i] << " ";
    }
    cout << endl;
}

void initialization(int array[], int size)
{
    for (int i = 0; i < size; i++)
    {
        array[i] = 0;
    }
}

void swap (int *a, int *b)
{
    int t = *a;
    *a = *b;
    *b = t;
}

void qsort(int array[], int left, int right)
{
    int i = left;
    int j = right;
    int x = array[left];
    while (i <= j)
    {
        while (i <= right && array[i] < x)
        {
            i++;
        }
        while (array[j] > x)
        {
            j--;
        }
        if (i <= j)
        {
            swap(array[i], array[j]);
            i++;
            j--;
        }
    }
    if (i < right)
    {
        qsort(array, i, right);
    }
    if (j > left)
    {
        qsort(array, left, j);
    }
}

int main()
{
    int n = 0;
    cout << "Введите длину массива: ";
    cin >> n;
    int *array = new int[n];
    initialization(array, n);
    inputArray(array, n);
    qsort(array, 0, n - 1);
    outputArray(array, n);
    delete [] array;
    return 0;
}

