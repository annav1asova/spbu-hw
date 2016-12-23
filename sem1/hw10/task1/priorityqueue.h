#pragma once

#include "tree.h"

struct PriorityQueue;

PriorityQueue* createQueue();
void add(PriorityQueue *queue, Tree *value, int key);
Tree *extractMin(PriorityQueue *queue);
void deleteQueue(PriorityQueue *queue);
bool isEmpty(PriorityQueue *queue);
int size(PriorityQueue *queue);
