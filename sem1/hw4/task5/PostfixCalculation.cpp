#include <iostream>
#include "Stack.h"
#include "postfixcalculation.h"
#include "infixtopostfix.h"

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
            intPush(stack, temp - '0');
        }

        if (temp == '+' || temp == '-' || temp == '*' || temp == '/')
        {
            int a = intPop(stack);
            int b = intPop(stack);
            intPush(stack, myOperator(b, a, temp));
        }
    }
    int result = intPop(stack);
    deleteIntStack(stack);
    return result;
}
