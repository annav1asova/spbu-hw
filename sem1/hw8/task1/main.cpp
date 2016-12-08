#include <iostream>

using namespace std;

int countOption(int student, int *version)
{
    if (version[student] <= 2)
        return version[student];
    else
        return countOption(version[student], version);
}

int main()
{
    cout << "Введите количество студентов: ";
    int students = 0;
    cin >> students;
    cout << "Введите столько же пар чисел (студент и тот, с кого он списал)" << endl;
    int *version = new int[students];
    int firstStudent = 0;
    int secondStudent = 0;
    for (int i = 0; i < students; i++)
    {
        cin >> firstStudent;
        cin >> secondStudent;
        version[firstStudent - 1] = secondStudent - 1;
    }
    cout << "Получившиеся пары:" << endl;
    for (int i = 0; i < students; i++)
    {
        int curOption = countOption(i, version);
        if (curOption == -1)
            cout << (i + 1) << " поленился списать" << endl;
        else
           cout << (i + 1) << " " << (curOption + 1) << endl;
    }
    delete [] version;
}
