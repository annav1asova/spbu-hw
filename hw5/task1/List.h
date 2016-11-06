#pragma once

struct List;

List* createList();
void add(List *list, int value);
void remove(List *list, int value);
int size(List *list);
void deleteList(List *list);
bool isEmpty(List *list);
void showList(List *list);

