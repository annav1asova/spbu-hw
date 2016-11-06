#pragma once

struct Stack;

Stack* createStack();
void push(Stack *s, int value);
int pop(Stack *s);
bool isEmpty(Stack const *s);
void deleteStack(Stack *s);
