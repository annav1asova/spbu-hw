#include <iostream>
#include "List.h"

using namespace std;

void addValue(List *list)
{
    cout << "Введите добавляемое значение: ";
    int value = 0;
    cin >> value;
    add(list, value);
    cout << "Значение добавлено" << endl;
}

void removeValue(List *list)
{
    cout << "Введите удаляемое значение: ";
    int value = 0;
    cin >> value;
    remove(list, value);
    cout << "Значение удалено" << endl;
}

void show(List *list)
{
    cout << "Полученный список: ";
    showList(list);
}

int main()
{
    List *list = createList();
    cout << "Вы можете вводить команды:" << endl;
    cout << "0 - exit;" << endl;
    cout << "1 - add a value to sorted list;" << endl;
    cout << "2 - remove a value from sorted list;" << endl;
    cout << "3 - print list" << endl;

    enum  Command {exit, add, remove, print};
    int inputCommand = 0;
    cin >> inputCommand;

    while (inputCommand){
        switch (inputCommand)
        {
        case exit:
            break;
        case add:
            addValue(list);
            break;
        case remove:
            removeValue(list);
            break;
        case print:
            show(list);
            break;
        }
        cin >> inputCommand;
    }
    deleteList(list);
}
