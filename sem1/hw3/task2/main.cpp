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
    inputArray(array, n);
    qsort(array, 0, n - 1);
    for (int i = n - 2; i >= 0; i--)
    {
        if (array[i] == array[i + 1])
        {
            cout << "Искомый элемент: " << array[i] << endl;
            break;
        }
    }
    delete [] array;
    return 0;
}
