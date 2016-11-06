#include <iostream>
#include "avltree.h"

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

    enum  Command {exit, add, remove, exists, printAscending, printDescdending, printTreeBrackets};
    cout << "Вы можете вводить команды:" << endl;
    cout << exit << " - exit;" << endl;
    cout << add << " - add a value to tree;" << endl;
    cout << remove << " - remove a value from tree;" << endl;
    cout << exists << " - exists " << endl;
    cout << printAscending << " - print ascending tree " << endl;
    cout << printDescdending << " - print descending tree " << endl;
    cout << printTreeBrackets << " - print tree with brackets" << endl;

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
