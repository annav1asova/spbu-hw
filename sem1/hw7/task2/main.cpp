#include <iostream>
#include "tree.h"

using namespace std;

int main()
{
    char str[10000] = {""};
    FILE *fin = fopen("input.txt", "r");
    fgets(str, 10000, fin);
    Tree *tree = createTree();
    parse(str, 0, tree);
    printAscendingTree(tree);
    cout << endl << "Значение выражения равно " << calculate(tree) << endl;
    deleteTree(tree);
    fclose(fin);
}
