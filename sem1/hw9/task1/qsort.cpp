#include <iostream>
#include "qsort.h"

using namespace std;

void swap (int *a, int *b)
{
    int t = *a;
    *a = *b;
    *b = t;
}

void qsort(int array[], int secondArray[], int left, int right)
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
            swap(secondArray[i], secondArray[j]);
            i++;
            j--;
        }
    }
    if (i < right)
    {
        qsort(array, secondArray, i, right);
    }
    if (j > left)
    {
        qsort(array, secondArray, left, j);
    }
}
