#pragma once

struct CircularList;

CircularList* createList();
void add(CircularList *list, int value);
void remove(CircularList *list, int value);
int size(CircularList *list);
void deleteList(CircularList *list);
bool isEmpty(CircularList *list);
void showList(CircularList *list);
int nextValue(CircularList *list, int value);
int valueOfFirst(CircularList *list);

