#include "list.h"
#include "mystring.h"
#include <string.h>
#include <iostream>

using namespace std;

struct ListElement
{
    String *value;
    ListElement *next;
    int quantity;
};

struct List
{
    ListElement *first;
    int size;

};

List* createList()
{
    List *list = new List;
    list->first = nullptr;
    list->size = 0;
    return list;
}

void deleteList(List *list)
{
    if (isEmpty(list))
    {
        delete list;
        return;
    }

    while (list->first->next != nullptr)
    {
        ListElement *toDelete = list->first;
        list->first = list->first->next;
        deleteString(toDelete->value);
        delete toDelete;
    }
    deleteString(list->first->value);
    delete list->first;
    delete list;
}

ListElement *createNewElement(String *value, ListElement *next)
{
    ListElement *newElement = new ListElement;
    newElement->next = next;
    newElement->quantity = 1;
    newElement->value = clone(value);

    return newElement;
}

List *addToEmptyList(List *list, String *value)
{
    ListElement *toAdd = createNewElement(value, nullptr);
    list->first = toAdd;
    list->size = 1;
    return list;
}

void add(List *list, String *value)
{
    if (isEmpty(list))
    {
        addToEmptyList(list, value);
        return;
    }

    if (equals(value, list->first->value))
    {
        list->first->quantity++;
        return;
    }

    ListElement *temp = list->first;
    while (temp->next != nullptr && !equals(value, temp->value))
    {
        temp = temp->next;
    }

    if (equals(value, temp->value))
    {
        temp->quantity++;
    }
    else
    {
        temp->next = createNewElement(value, temp->next);
        list->size++;
    }
}

bool isEmpty(List *list)
{
    return !size(list);
}

int size(List *list)
{
    return list->size;
}

void printList(List *list)
{
    ListElement *temp = list->first;
    while (temp != nullptr)
    {
        print(temp->value);
        temp = temp->next;
    }
}

int searchWord(List *list, String *string)
{
    ListElement *temp = list->first;
    while (temp != nullptr && !equals(temp->value, string))
        temp = temp->next;

    if (temp == nullptr)
        return 0;
    else
        return temp->quantity;

}
