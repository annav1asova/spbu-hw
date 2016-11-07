#pragma once

struct Stack;

Stack* createStack();
void push(Stack *s, char value);
char pop(Stack *s);
char peek(Stack *s);
bool isEmpty(Stack const *s);
void deleteStack(Stack *s);
void infixToPostfix(int index, char myString[], int current, char resultString[]);
