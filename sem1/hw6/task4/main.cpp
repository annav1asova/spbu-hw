#include <iostream>

using namespace std;

int main()
{
    FILE *fp = fopen("input.txt","r");
    char str[10000] = {""};
    int result = 0;

    while(!feof(fp))
    {
        if(fgets(str, 10000, fp))
        {
            int i = 0;
            bool isEmpty = true;
            while (str[i] != '\n')
            {
                if (str[i] != ' ' && str[i] != '\t')
                    isEmpty = false;
                i++;
            }
            if (!isEmpty)
                result++;
        }
    }
    //cout << "Непустых строк в файле " << result << " штук" << endl;

    fclose(fp);
}
