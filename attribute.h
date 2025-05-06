#include <iostream>
#include <vector>

static string class_name = "";

vector<string> get_attribute(string entity) {
    int n = entity.length();
    int i = 0;
    int j = 0;
    string temp = "";
    string table = "";
    vector<string> attributes;

    while(i < n) {
        if(entity[i] != '(') {
            table = table + entity[i];
        }else {
            j = i + 1;
            while(j < n) {
                if((entity[j] != ',') && (entity[j] != ')')) {
                    temp = temp + entity[j];
                }else {
                    attributes.push_back(temp);
                    temp = "";
                }
                j = j + 1;
            }
            i = n; // na break
        }
        i = i + 1;
    }
    class_name = table;
    return attributes;
}

vector<string> get_attribute_name(vector<string> attributes) {
    int n = attributes.size();
    int i = 0, j = 0, k = 0;
    string temp = "";
    vector<string> attribute_name;

    while(i < n) {
        int m = attributes[i].size();
        j = 0;
        while(j < m) {
            if(attributes[i][j] == ' ') {
                k = j + 1;
                while(k < m) {
                    temp += attributes[i][k];
                    k = k + 1;
                }
                j = m; // na break
                attribute_name.push_back(temp);
                temp = "";
            }
            j = j + 1;
        }
        i = i + 1;
    }

    return attribute_name;
}