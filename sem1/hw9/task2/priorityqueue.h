#pragma once

#include "astar.h"

struct PriorityQueue;

PriorityQueue* createQueue();
void add(PriorityQueue *queue, Point *p, int key);
Point *extractMin(PriorityQueue *queue);
void deleteQueue(PriorityQueue *queue);
bool isEmpty(PriorityQueue *queue);
int size(PriorityQueue *queue);
Point *exists(PriorityQueue *queue, int x, int y);
void remove (PriorityQueue *queue, int x, int y);
