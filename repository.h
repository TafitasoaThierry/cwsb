#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

string type_of_id(string id, int i) {
    if(id[i] != ' ') {
        return id[i] + type_of_id(id, i + 1);
    }else {
        return "";
    }
}

void create_repository(string package, string class_name, vector<string> attributes) {
    string data_type = type_of_id(attributes[0], 0); // id = attributes[0]
    class_name[0] = toupper(class_name[0]);
    ofstream repository("repository/" + class_name + "Repository.java");

    repository << "package " << package << ".repository;" << endl
               << endl

               << "import " + package + ".model." + class_name + ";" << endl
               << endl

               << "import org.springframework.data.jpa.repository.JpaRepository;" << endl
               << endl
               
               << "public interface " + class_name + "Repository" + " extends JpaRepository<" + class_name + ", " + data_type + "> {}" << endl;
}