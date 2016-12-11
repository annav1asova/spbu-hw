#include <iostream>
#include "dijkstra.h"
#include "qsort.h"

using namespace std;

void dijkstra(int vertex, int **matrix, int inf)
{
    int *array = new int[vertex];
    int *distance = new int[vertex];
    int *distanceClone = new int[vertex];
    int *parent = new int[vertex];
    bool *used = new bool[vertex];

    for (int i = 0; i < vertex; i++)
    {
        distance[i] = inf;
        distanceClone[i] = inf;
        parent[i] = -1;
        used[i] = false;
        array[i] = i + 1;
    }
    distance[0] = 0;
    for (int i = 0; i < vertex; i++)
    {
        int v = -1;
        for (int j = 0; j < vertex; j++)
        {
            if (!used[j] && (v == -1 || distance[j] < distance[v]))
                v = j;
        }
        if (distance[v] == inf)
        {
            break;
        }
        used[v] = true;
        for (int j = 0; j < vertex; j++)
        {
            if (matrix[v][j] > 0 && distance[v] + matrix[v][j] < distance[j])
            {
                distance[j] = distance[v] + matrix[v][j];
                distanceClone[j] = distanceClone[v] + matrix[v][j];
                parent[j] = v;
            }
        }
    }
    output(vertex, distance, distanceClone, parent, array, inf);
    delete [] array;
    delete [] distance;
    delete [] distanceClone;
    delete [] parent;
    delete [] used;
}

void output(int vertex, int distance[], int distanceClone[], int parent[], int array[], const int inf)
{
    qsort(distanceClone, array, 0, vertex - 1);
    cout << endl;
    cout << "Порядок захвата: ";
    for (int i = 0; i < vertex; i++)
    {
        if (distanceClone[i] != inf)
            cout << array[i] << " ";
    }
    cout << endl;
    for (int i = 1; i < vertex; i++)
    {
        if (distance[i] < inf)
        {
            cout << "Расстояние до " << i + 1 << " : " << distance[i] << endl;
            cout << "Путь до " << i + 1 << " : " << i + 1 << " ";
            int cur = i;
            while (cur != 0 && parent[cur] != -1)
            {
                cur = parent[cur];
                cout << cur + 1 << " ";
            }
            cout << endl;
        }
    }
}


