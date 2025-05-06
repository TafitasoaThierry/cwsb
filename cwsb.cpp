#include <iostream>
#include <vector>
#include <unistd.h>
#include "model.h"
#include "repository.h"
#include "service.h"
#include "controller.h"

using namespace std;

void clean(string *entity = nullptr) {
    string str = *entity;
    string temp = "";
    int n = str.length();
    int i = 0;

    while(i < n) {
        if((str[i] == ' ') && (str[i - 1] == ',')) {
            cout << "";
        }else {
            temp += str[i];
        }
        i = i + 1;
    }
    *entity = temp;
}

int main(int argv, char *argc[]) {
    string entity = "";
    string package = argc[1];
    vector<string> attribute;

    do{
        cout << "cwsb > ";
        getline(cin, entity);

        clean(&entity);
        attribute = get_attribute(entity);
        if((entity != ";") && (attribute.size() > 0)) {
            create_model(package, class_name, attribute);
            create_repository(package, class_name, attribute);
            create_service(package, class_name,attribute);
            create_controller(package, class_name, attribute);
            cout << "[Info] zakako!!!" << endl;
        }else {
            cout << "[Error] can't generate code with '" + entity + "'" << endl;
            cout << " Syntax : 'Table(type name, type name, ...)'" << endl;
        }
    }while(entity != ";");

    return 0;
}