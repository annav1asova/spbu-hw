#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <fstream>

using namespace std;

void viewComments(FILE *fp)
{
    bool textLine = false;
    bool blockComments = false;
    char str[10000];

    while(!feof(fp))
    {
        bool isComment = false;
        if(fgets(str, 10000, fp))
        {
            int i = 0;
            while (str[i] != '\n')
            {
                if (isComment)
                    cout << str[i];

                else if (str[i - 1] == '/' && str[i] == '/' && !textLine && !blockComments)
                {
                    cout << str[i - 1] << str[i];
                    isComment = true;
                }

                else if (str[i] == '"' && !blockComments)
                    textLine = !textLine;

                else if (str[i - 1] == '/' && str[i] == '*' && !blockComments && !textLine)
                    blockComments = true;

                else if (str[i - 1] == '*' && str[i] == '/' && blockComments && !textLine)
                    blockComments = false;
                i++;
            }
            if (isComment)
                cout << endl;
        }
    }
}

int main()
{
    FILE *fp;
    fp = fopen("/Users/annavlasova/Hw_5_n3/input.txt","r");

    viewComments(fp);

    fclose(fp);
}
