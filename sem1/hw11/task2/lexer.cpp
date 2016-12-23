#include "lexer.h"

bool isDigit(char s)
{
    return (s >= '0' && s <= '9');
}

bool isSign(char s)
{
    return (s == '-' || s == '+');
}

bool isDot(char s)
{
    return (s == '.');
}

bool isE(char s)
{
    return (s == 'E');
}

bool isCorrectDouble(char string[], int &index)
{
    int state = 0;
    enum State {signOrFirstDigit, firstOrSecondDigit, digitsBeforeDorOrE, firstDigitAfterDot, digitsAfterDotOrE, singEOrFirstDigitOfPower, firstOrSecondDigitOfPower, powerDigits};
    while (string[index] != ' ' && string[index] != '\n' && string[index] != '\0')
    {
        char symb = string[index];
        switch (state)
        {
            case signOrFirstDigit:
                if (isSign(symb))
                    state = firstOrSecondDigit;
                else if (isDigit(symb))
                    state = digitsBeforeDorOrE;
                else
                    return false;
                break;
            case firstOrSecondDigit:
                if (isDigit(symb))
                    state = digitsBeforeDorOrE;
                else
                    return false;
                break;
            case digitsBeforeDorOrE:
                if (isDigit(symb))
                    state = digitsBeforeDorOrE;
                else if (isDot(symb))
                    state = firstDigitAfterDot;
                else if (isE(symb))
                    state = singEOrFirstDigitOfPower;
                else
                    return false;
                break;
            case firstDigitAfterDot:
                if (isDigit(symb))
                    state = digitsAfterDotOrE;
                else
                    return false;
                break;
            case digitsAfterDotOrE:
                if (isDigit(symb))
                    state = digitsAfterDotOrE;
                else if (isE(symb))
                    state = singEOrFirstDigitOfPower;
                else
                    return false;
                break;
            case singEOrFirstDigitOfPower:
                if (isSign(symb))
                    state = firstOrSecondDigitOfPower;
                else if (isDigit(symb))
                    state = powerDigits;
                else
                    return false;
                break;
            case firstOrSecondDigitOfPower:
                if (isDigit(symb))
                    state = powerDigits;
                else
                    return false;
                break;
            case powerDigits:
                if (isDigit(symb))
                    state = powerDigits;
                else
                    return false;
                break;
        }
        index++;
    }
    if (state == digitsBeforeDorOrE || state == digitsAfterDotOrE || state == powerDigits)
        return true;
    else
        return false;
}
