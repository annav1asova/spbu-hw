#include <iostream>
#include "Stack.h"

using namespace std;

int priority(char a)
{
    if (a == '(')
        return 0;
    if (a == '+' || a == '-')
        return 1;
    if (a == '*' || a == '/')
        return 2;
}

void output(int size, char array[])
{
    for (int i = 0; i < size; i++)
    {
        cout << array[i] << " ";
    }
    cout << endl;
}

void infixToPostfix(int index, char myString[], int current, char resultString[])
{
    Stack *stack = createStack();
    for (int i = 0; i < index; i++)
    {
        char temp = myString[i];

        if ((int)temp >= int('0') && (int)temp <= int('9'))
        {
            resultString[current] = temp;
            current++;
        }
        else if (temp == '(')
        {
            push(stack, temp);
        }
        else if (temp == ')')
        {
            char topToken = pop(stack);
            while (topToken != '(')
            {
                resultString[current] = topToken;
                current++;
                topToken = pop(stack);
            }
        }
        else if (temp == '+' || temp == '-' || temp == '*' || temp == '/')
        {
            while (!isEmpty(stack) && priority(peek(stack)) >= priority(temp))
            {
                resultString[current] = pop(stack);
                current++;
            }
            push(stack, temp);
        }
    }
    while (!isEmpty(stack))
    {
        resultString[current] = pop(stack);
        current++;
    }
    deleteStack(stack);
    output(current, resultString);
}
