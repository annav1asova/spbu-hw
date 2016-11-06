#include <iostream>
#include "Stack.h"
#include <fstream>

using namespace std;

int myOperator(int a, int b, char c)
{
    if (c == '+')
        return a + b;
    if (c == '-')
        return a - b;
    if (c == '*')
        return a * b;
    if (c == '/')
        return a / b;
}
bool isDigit(char temp)
{
    return (temp >= '0' && temp <= '9');
}

int postfixCalculation(int index, char myString[])
{
    Stack *stack = createStack();
    for (int i = 0; i < index; i++)
    {
        char temp = myString[i];

        if (isDigit(temp))
        {
            push(stack, temp - '0');
        }

        if (temp == '+' || temp == '-' || temp == '*' || temp == '/')
        {
            int a = pop(stack);
            int b = pop(stack);
            push(stack, myOperator(b, a, temp));
        }
    }
    int result = pop(stack);
    deleteStack(stack);
    return result;
}
