#include <iostream>
#include "tree.h"

using namespace std;

void addValue(Tree *tree)
{
    cout << "Введите добавляемое значение: ";
    int value = 0;
    cin >> value;
    add(tree, value);
    cout << "Значение добавлено" << endl;
}

void removeValue(Tree *tree)
{
    cout << "Введите удаляемое значение: ";
    int value = 0;
    cin >> value;
    remove(tree, value);
    cout << "Значение удалено" << endl;
}

void isValueInTree(Tree *tree)
{
    cout << "Введите значение: ";
    int value = 0;
    cin >> value;
    if (exists(tree, value))
        cout << "Данное значение есть в дереве" << endl;
    else
        cout << "Этого значения в дереве нет" << endl;
}

int main()
{
    Tree *tree = createTree();

    cout << "Вы можете вводить команды:" << endl;
    cout << "0 - exit;" << endl;
    cout << "1 - add a value to tree;" << endl;
    cout << "2 - remove a value from tree;" << endl;
    cout << "3 - exists " << endl;
    cout << "4 - print ascending tree " << endl;
    cout << "5 - print descending tree " << endl;
    cout << "6 - print tree with brackets" << endl;

    enum  Command {exit, add, remove, exists, printAscending, printDescdending, printTreeBrackets};
    int inputCommand = 0;
    cin >> inputCommand;

    while (inputCommand){
        switch (inputCommand)
        {
        case exit:
            break;
        case add:
            addValue(tree);
            break;
        case remove:
            removeValue(tree);
            break;
        case exists:
            isValueInTree(tree);
            break;
        case printAscending:
            cout << "Элементы дерева по возрастанию: ";
            printAscendingTree(tree);
            cout << endl;
            break;
        case printDescdending:
            cout << "Элементы дерева по убыванию: ";
            printDescendingTree(tree);
            cout << endl;
            break;
        case printTreeBrackets:
            cout << "Элементы дерева (вывод со скобочками): ";
            printTree(tree);
            cout << endl;
            break;
        }
        cin >> inputCommand;
    }
    deleteTree(tree);
}
