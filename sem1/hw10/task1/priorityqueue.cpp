#include "priorityqueue.h"
#include "tree.h"

struct QueueElement
{
    Tree *value;
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
QueueElement *createNewElement(Tree *value, int key, QueueElement *next)
{
    QueueElement *newElement = new QueueElement;
    newElement->next = next;
    newElement->value = value;
    newElement->key = key;
    return newElement;
}

void add(PriorityQueue *queue, Tree *value, int key)
{
    if (isEmpty(queue))
    {
        queue->head = createNewElement(value, key, nullptr);
        queue->size++;
        return;
    }

    if (queue->head->key > key)
    {
        queue->head = createNewElement(value, key, queue->head);
        queue->size++;
        return;
    }

    QueueElement *temp = queue->head;
    while (temp->next != nullptr && key > temp->next->key)
    {
        temp = temp->next;
    }
    temp->next = createNewElement(value, key, temp->next);
    queue->size++;
}

Tree *extractMin(PriorityQueue *queue)
{
    if (isEmpty(queue))
        return nullptr;

    Tree *minPrioritySymbol = queue->head->value;
    queue->head = queue->head->next;
    queue->size--;
    return minPrioritySymbol;
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
        queue->head = queue->head->next;
        deleteTree(toDelete->value);
        delete toDelete;
    }
    delete queue->head;
    delete queue;
}

bool isEmpty(PriorityQueue *queue)
{
    return (queue->size == 0);
}

int size(PriorityQueue *queue)
{
    return queue->size;
}
