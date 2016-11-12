#pragma once

struct Stack;

Stack* createStack();
void charPush(Stack *s, char value);
void intPush(Stack *s, int value);
char charPop(Stack *s);
int intPop(Stack *s);
char peek(Stack *s);
bool isEmpty(Stack const *s);
void deleteCharStack(Stack *s);
void deleteIntStack(Stack *s);




