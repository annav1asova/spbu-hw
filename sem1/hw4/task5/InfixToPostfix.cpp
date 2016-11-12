#include <iostream>
#include "Stack.h"
#include "postfixcalculation.h"
#include "infixtopostfix.h"

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

int infixToPostfix(int index, char myString[], int current, char resultString[])
{
    Stack *stack = createStack();
    for (int i = 0; i < index; i++)
    {
        char temp = myString[i];

        if (isDigit(temp))
        {
            resultString[current] = temp;
            current++;
        }
        else if (temp == '(')
        {
            charPush(stack, temp);
        }
        else if (temp == ')')
        {
            char topToken = charPop(stack);
            while (topToken != '(')
            {
                resultString[current] = topToken;
                current++;
                topToken = charPop(stack);
            }
        }
        else if (temp == '+' || temp == '-' || temp == '*' || temp == '/')
        {
            while (!isEmpty(stack) && priority(peek(stack)) >= priority(temp))
            {
                resultString[current] = charPop(stack);
                current++;
            }
            charPush(stack, temp);
        }
    }
    while (!isEmpty(stack))
    {
        resultString[current] = charPop(stack);
        current++;
    }
    deleteCharStack(stack);
    return postfixCalculation(current, resultString);
}
