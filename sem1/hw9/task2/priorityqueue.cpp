#include "priorityqueue.h"

struct QueueElement
{
    Point *point;
    int key;
    QueueElement *next;
};

struct PriorityQueue
{
    QueueElement *head;
    int size;
};

PriorityQueue* createQueue()
{
    PriorityQueue *queue = new PriorityQueue;
    queue->head = nullptr;
    queue->size = 0;
    return queue;
}

QueueElement *createNewElement(Point *p, int key, QueueElement *next)
{
    QueueElement *newElement = new QueueElement;
    newElement->next = next;
    newElement->point = p;
    newElement->key = key;
    return newElement;
}

void add(PriorityQueue *queue, Point *p, int key)
{
    if (isEmpty(queue))
    {
        queue->head = createNewElement(p, key, nullptr);
        queue->size++;
        return;
    }

    if (queue->head->key > key)
    {
        queue->head = createNewElement(p, key, queue->head);
        queue->size++;
        return;
    }

    QueueElement *temp = queue->head;
    while (temp->next != nullptr && key > temp->next->key)
    {
        temp = temp->next;
    }
    temp->next = createNewElement(p, key, temp->next);
    queue->size++;
}

Point *extractMin(PriorityQueue *queue)
{
    if (isEmpty(queue))
        return nullptr;

    Point *p = queue->head->point;
    queue->head = queue->head->next;
    queue->size--;
    return p;
}

void deleteQueue(PriorityQueue *queue)
{
    if (isEmpty(queue))
    {
        delete queue;
        return;
    }
    while (queue->head->next != nullptr)
    {
        QueueElement *toDelete = queue->head;
        delete toDelete->point;
        queue->head = queue->head->next;
        delete toDelete;
    }
    delete queue->head->point;
    delete queue->head;
    delete queue;
}

Point *exists(PriorityQueue *queue, int x, int y)
{
    if (isEmpty(queue))
        return nullptr;

    QueueElement *temp = queue->head;
    while (temp->next != nullptr && (temp->point->x != x || temp->point->y != y))
    {
        temp = temp->next;
    }

    if (temp->point->x == x && temp->point->y == y)
        return temp->point;
    else
        return nullptr;
}

void remove(PriorityQueue *queue, int x, int y)
{
    if (isEmpty(queue))
        return;

    QueueElement *temp = queue->head;

    if (temp->next == nullptr && temp->point->x == x && temp->point->y == y)
    {
        delete temp;
        queue->head = nullptr;
        queue->size = 0;
        return;
    }

    if (temp->point->x == x && temp->point->y == y)
    {
        queue->head = temp->next;
        queue->size--;
        delete temp;
        return;
    }

    while (temp->next != nullptr && (temp->next->point->x != x || temp->next->point->y != y))
        temp = temp->next;

    if (temp->next == nullptr)
        return;

    QueueElement *toDelete = temp->next;
    temp->next = temp->next->next;
    delete toDelete;
    queue->size--;

}

bool isEmpty(PriorityQueue *queue)
{
    return (queue->size == 0);
}

int size(PriorityQueue *queue)
{
    return queue->size;
}
