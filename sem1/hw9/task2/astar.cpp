#include "priorityqueue.h"
#include "astar.h"
#include <stdlib.h>
#include <iostream>

using namespace std;

int heuristicFunction(Point *first, int secondX, int secondY)
{
    return abs(first->x - secondX) + abs(first->y - secondY);
}

Point *considerPoint(int x, int y, PriorityQueue *queue, Point *prevPoint, int finishX, int finishY)
{
    if (x == finishX && y == finishY)
        return prevPoint;

    Point *point = exists(queue, x, y);
    if (point != nullptr && prevPoint->lengthFromStart + 1 < point->lengthFromStart)
        remove(queue, x, y);

    if (point == nullptr || (point != nullptr && prevPoint->lengthFromStart + 1 < point->lengthFromStart))
    {
        Point *newPoint = new Point;
        newPoint->x = x;
        newPoint->y = y;
        newPoint->heuristic = heuristicFunction(newPoint, finishX, finishY);
        newPoint->parent = prevPoint;
        newPoint->lengthFromStart = prevPoint->lengthFromStart + 1;
        int key = newPoint->heuristic + newPoint->lengthFromStart;
        add(queue, newPoint, key);
    }
    return nullptr;
}

Point *considerAdjacent(Point *point, int **map, bool **used, PriorityQueue *queue, int finishX, int finishY, int n, int m)
{
    Point *finishPrevOrNothing = nullptr;
    if (point->x > 0 && !used[point->x - 1][point->y] && !map[point->x - 1][point->y] && !finishPrevOrNothing)
        finishPrevOrNothing = considerPoint(point->x - 1, point->y, queue, point, finishX, finishY);

    if (point->y > 0 && !used[point->x][point->y - 1] && !map[point->x][point->y - 1] && !finishPrevOrNothing)
        finishPrevOrNothing = considerPoint(point->x, point->y - 1, queue, point, finishX, finishY);

    if (point->x < n - 1 && !used[point->x + 1][point->y] && !map[point->x + 1][point->y] && !finishPrevOrNothing)
        finishPrevOrNothing = considerPoint(point->x + 1, point->y, queue, point, finishX, finishY);

    if (point->y < m - 1 && !used[point->x][point->y + 1] && !map[point->x][point->y + 1] && !finishPrevOrNothing)
        finishPrevOrNothing = considerPoint(point->x, point->y + 1, queue, point, finishX, finishY);

    return finishPrevOrNothing;
}

void printMap(int **map, int n, int m)
{
    cout << "Искомый путь помечен #: " << endl;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (map[i][j] == 2)
                cout << "# ";
            else
                cout << map[i][j] << " ";
        }
        cout << endl;
    }
}

void astar(int **map, int n, int m, int startX, int startY, int finishX, int finishY)
{
    PriorityQueue* queue = createQueue();

    bool **used = new bool*[n];
    for (int i = 0; i < n; i++)
    {
        used[i] = new bool[m];
        for (int j = 0; j < m; j++)
        {
            used[i][j] = false;
        }
    }
    Point *start = new Point;
    start->x = startX;
    start->y = startY;

    add(queue, start, 0);
    Point *finishPrevOrNothing;
    while (!isEmpty(queue))
    {
        Point *current = extractMin(queue);
        used[current->x][current->y] = true;
        finishPrevOrNothing = considerAdjacent(current, map, used, queue, finishX, finishY, n, m);
        if (finishPrevOrNothing != nullptr)
            break;
    }
    if (finishPrevOrNothing == nullptr)
        cout << "Между этими вершинами нет пути" << endl;
    else
    {
        map[finishX][finishY] = 2;
        Point *current = finishPrevOrNothing;
        while (current->x != startX || current->y != startY)
        {
            map[current->x][current->y] = 2;
            current = current->parent;
        }
        map[startX][startY] = 2;
        printMap(map, n, m);
    }
    delete start;
    delete finishPrevOrNothing;
    deleteQueue(queue);
    for (int i = 0; i < n; i++)
        delete [] used[i];
}
