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
void heapify(int array[], int pos, int n)
{
    int leftChild = 2 * pos + 1;
    int rightChild = 2 * pos + 2;
    while (leftChild < n)
    {
        int t = leftChild;
        if (rightChild < n && array[rightChild] >= array[t])
        {
            t = rightChild;
        }
        if (array[pos] < array[t])
        {
            swap(array[pos], array[t]);
            pos = t;
            leftChild = 2 * pos + 1;
            rightChild = 2 * pos + 2;
        }
        else break;
    }
}

void makeHeap(int array[], int n)
{
    for (int i = n - 1; i >= 0; i--)
    {
        heapify(array, i, n);
    }
}

void heapSort(int array[], int n)
{
    makeHeap(array, n);
    while (n > 0)
    {
        swap(array[0], array[n - 1]);
        n--;
        heapify(array, 0, n);
    }
}

int main()
{
    int n;
    cout << "Введите длину массива: ";
    cin >> n;
    int *array = new int[n];
    initialization(array, n);
    inputArray(array, n);
    heapSort(array, n);
    outputArray(array, n);
    delete [] array;
    return 0;
}
