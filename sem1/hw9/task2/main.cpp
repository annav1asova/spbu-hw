#include <iostream>
#include <fstream>
#include "astar.h"

using namespace std;

int main()
{
    ifstream fin("input.txt");
    int n = 0;
    fin >> n;
    int m = 0;
    fin >> m;
    int **map = new int*[n];
    for (int i = 0; i < n; i++)
    {
        map[i] = new int[m];
        for (int j = 0; j < m; j++)
        {
            map[i][j] = 0;
        }
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
            fin >> map[i][j];
    }
    int startX = 0;
    fin >> startX;
    int startY = 0;
    fin >> startY;
    int finishX = 0;
    fin >> finishX;
    int finishY = 0;
    fin >> finishY;
    astar(map, n, m, startX - 1, startY - 1, finishX - 1, finishY - 1);
    for (int i = 0; i < n; i++)
        delete [] map[i];

    fin.close();
}
