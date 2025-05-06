#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

void create_model(string package, string class_name, vector<string> attributes) {
    class_name[0] = toupper(class_name[0]);
    ofstream model("model/" + class_name + ".java");
    string jpa_package = "import jakarta.persistence.";

    model << "package " << package << ".model;" << endl
          << endl;

    model << jpa_package + "Entity;" << endl
          << jpa_package + "Table;" << endl
          << jpa_package + "Id;" << endl
          << "import lombok.Getter;" << endl
          << "import lombok.Setter;" << endl
          << endl;

    model << "@Entity" << endl
          << "@Table(name = \"" + class_name + "\")" << endl
          << "@Getter" << endl
          << "@Setter" << endl
          << "public class " + class_name << " {" << endl;

    model << "\t@Id" << endl;
    for(auto attribute:attributes) {
        model << "\tprivate " + attribute + ";" <<endl;
    }
    model << "}" << endl;
}