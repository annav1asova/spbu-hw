#include <iostream>
#include <cmath>

using namespace std;

void generation(int size, int array[])
{
    srand(time(0));
    for (int i = 0; i < size; i++)
    {
        array[i] = rand() % 1000000000;
    }
}
bool binSearch(int array[], int left, int right, int key){
    int middle = (left + right) / 2;
    if (left >= right)
    {
        return false;
    }
    if (array[middle] == key)
    {
        return true;
    }
    else if (array[middle] > key)
    {
        return binSearch(array, left, middle, key);
    }
    else
    {
        return binSearch(array, middle + 1, right, key);
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
    cout << "Введите n: ";
    int n = 0;
    cin >> n;
    int *firstArray = new int[n];
    generation(n, firstArray);
    qsort(firstArray, 0, n - 1);
    for (int i = 0; i < n; i++){
        cout << firstArray[i] << " ";
    }
    cout << endl;
    
    cout << "Введите k: ";
    int k = 0;
    cin >> k;
    int *secondArray = new int[k];
    generation(k, secondArray);
    
    for (int i = 0; i < k; i++)
    {
        if (binSearch(firstArray, 0, n, secondArray[i]))
        {
            cout << secondArray[i] << " есть в массиве" << endl;
        }
        else
        {
            cout << secondArray[i] << " нет в массиве" << endl;
        }
    }
    delete [] firstArray;
    delete [] secondArray;
    return 0;
}
