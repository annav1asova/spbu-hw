#include <iostream>
#include <fstream>
#include "qsort.h"
#include "dijkstra.h"

using namespace std;

int main()
{
    const int inf = 100000000;

    ifstream fin("input.txt");
    int vertex = 0;
    fin >> vertex;
    int edge = 0;
    fin >> edge;
    int **matrix = new int*[vertex];
    for (int i = 0; i < vertex; i++)
    {
        matrix[i] = new int[vertex];
        for (int j = 0; j < vertex; j++)
        {
            matrix[i][j] = 0;
        }
    }

    for (int i = 0; i < edge; i++)
    {
        int firstVertex = 0;
        fin >> firstVertex;
        int secondVertex = 0;
        fin >> secondVertex;
        int length = 0;
        fin >> length;
        matrix[firstVertex - 1][secondVertex - 1] = length;
        matrix[secondVertex - 1][firstVertex - 1] = length;
    }

    dijkstra(vertex, matrix, inf);

    for (int i = 0; i < vertex; i++)
    {
        delete [] matrix[i];
    }
    delete [] matrix;
}
