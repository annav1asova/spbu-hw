#include "circularlist.h"
#include <iostream>

using namespace std;

struct CircularListElement
{
    int value;
    CircularListElement *next;
};

struct CircularList
{
    CircularListElement *first;
    int size;

};

CircularList* createList()
{
    CircularList *list = new CircularList;
    list->first = nullptr;
    list->size = 0;
    return list;
}

void deleteList(CircularList *list)
{
    if (isEmpty(list))
        return;

    CircularListElement *temp = list->first;
    while(temp->next != list->first)
    {
        CircularListElement *toDelete = temp->next;
        temp->next = temp->next->next;
        delete toDelete;
    }
    delete list->first;
    delete list;
}

CircularListElement *createNewElement(int value, CircularListElement *next)
{
    CircularListElement *newElement = new CircularListElement;
    newElement->next = next;
    newElement->value = value;
    return newElement;
}

void addToEmptyList(CircularList *list, int value)
{
    CircularListElement *toAdd = createNewElement(value, toAdd);
    list->size++;
    list->first = toAdd;
}

void addToHead(CircularList *list, int value)
{
    CircularListElement *toAdd = createNewElement(value, list->first);

    CircularListElement *temp = list->first;
    while (temp->next != list->first)
    {
        temp = temp->next;
    }
    temp->next = toAdd;
    list->first = toAdd;
    list->size++;
}

void add(CircularList *list, int value)
{
    if (isEmpty(list))
    {
        addToEmptyList(list, value);
        return;
    }

    if (value < list->first->value)
    {
        addToHead(list, value);
        return;
    }

    if (size(list) == 1)
    {
        CircularListElement *toAdd = createNewElement(value, list->first);
        list->first->next = toAdd;
        list->size++;
        return;
    }

    CircularListElement *temp = list->first;
    while (value > temp->next->value && temp->next != list->first)
    {
        temp = temp->next;
    }
    CircularListElement *toAdd = createNewElement(value, temp->next);
    temp->next = toAdd;

    list->size++;
}

void remove(CircularList *list, int value)
{
    if (isEmpty(list))
        return;

    CircularListElement *temp = list->first;
    if (temp == temp->next && temp->value == value)
    {
        delete temp;
        list->first = nullptr;
        list->size = 0;
        return;
    }

    if(temp->value == value)
    {
        while (temp->next != list->first)
        {
            temp = temp->next;
        }
        CircularListElement *toDelete = temp->next;
        temp->next = temp->next->next;
        list->first = temp->next;
        list->size--;
        delete toDelete;
        return;
    }

    while (temp->next->value != value && temp->next != list->first)
    {
        temp = temp->next;
    }
    if (temp->next == list->first)
    {
        return;
    }
    CircularListElement *toDelete = temp->next;
    temp->next = temp->next->next;
    delete toDelete;
    list->size--;
}

int size(CircularList *list)
{
    return list->size;
}

bool isEmpty(CircularList *list)
{
    return (!size(list));
}

void showList(CircularList *list)
{
    CircularListElement *temp = list->first;
    while (temp->next != list->first)
    {
        cout << temp->value << " ";
        temp = temp->next;
    }
    cout << temp->value << endl;
}

int nextValue(CircularList *list, int value)
{
    if (isEmpty(list))
        return -1;

    CircularListElement *temp = list->first;

    while (temp->value != value && temp != temp->next)
    {
        temp = temp->next;
    }

    if (temp->value == value)
        return temp->next->value;
    else
        return -1;
}

int valueOfFirst(CircularList *list)
{
    return list->first->value;
}
