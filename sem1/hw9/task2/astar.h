#ifndef _ASTAR_H_
#define _ASTAR_H_

struct Point
{
    int x;
    int y;
    int heuristic;
    int lengthFromStart;
    Point *parent;
};

void astar(int **map, int n, int m, int startX, int startY, int finishX, int finishY);

#endif
