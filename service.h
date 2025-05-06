#include <iostream>
#include <fstream>
#include <vector>
#include "attribute.h"

void create_service(string package, string class_name, vector<string> attributes) {
    class_name[0] = toupper(class_name[0]);
    string class_instance = class_name;
    class_instance[0] = tolower(class_instance[0]);
    string repository_class = class_name + "Repository";
    string repository_instance = class_instance + "Repository";
    vector<string> attribute_name = get_attribute_name(attributes);
    ofstream service("service/" + class_name + "Service.java");

    service << "package " + package + ".service;" << endl
            << endl
            << "import " + package + ".model." + class_name << ";" << endl
            << "import " + package + ".repository." + class_name + "Repository;" << endl
            << endl
            << "import jakarta.el.ELException;" << endl
            << endl
            << "import java.util.List;" << endl
            << endl
            << "import org.springframework.stereotype.Service;" << endl
            << endl;

    service << "@Service" << endl
            << "public class " + class_name + "Service {" << endl
            << "\tfinal " + repository_class + " " + repository_instance + ";" << endl
            << endl

            // constructor
            << "\tpublic " + class_name + "Service(" + repository_class + " " + repository_instance + ") {" << endl
            << "\t\tthis." + repository_instance + " = " + repository_instance + ";" << endl
            << "\t}" << endl
            << endl

            // create
            << "\tpublic " + class_name + " add" + class_name + "(" + class_name + " new" + class_name + ") {" << endl
            << "\t\treturn this." + repository_instance + ".save(new" + class_name + ");" << endl
            << "\t}" << endl
            << endl 

            // read
            << "\tpublic List<"+ class_name + "> get" + class_name + "List() {" << endl
            << "\t\treturn this." + repository_instance + ".findAll();" << endl
            << "\t}" << endl
            << endl

            // delete
            << "\tpublic String delete" + class_name + "(" + attributes[0] + ") {" << endl
            << "\t\tif(this." + repository_instance + ".findById(" + attribute_name[0] + ").isPresent()) {" << endl
            << "\t\t\tthis." + repository_instance + ".deleteById(" + attribute_name[0] + ");" << endl
            << "\t\t\treturn \"" + class_instance + " deleted\";" << endl
            << "\t\t}else {" << endl
            << "\t\t\treturn " + attribute_name[0] + ".toString() + \" isn't in " + class_instance + " list\";" << endl
            << "\t\t}" << endl
            << "\t}" << endl
            << endl;
            
            // update
    service << "\tpublic " + class_name + " update" + class_name + "(" + attributes[0] + ", " + class_name + " new" + class_name + "Info) {" << endl
            << "\t\tif(this." + repository_instance + ".findById(" + attribute_name[0] + ").isPresent()) {" << endl
            << "\t\t\t" + class_name + " " + class_instance + "Info = this." + repository_instance + ".findById(" + attribute_name[0] + ").get();" << endl;
    
    // for getter and setter
    for(int i = 1; i < attribute_name.size(); i++) {
        attribute_name[i][0] = toupper(attribute_name[i][0]);
        service << "\t\t\t" + class_instance + "Info.set" + attribute_name[i] + "(new" + class_name + "Info.get" + attribute_name[i] + "());" << endl;
    }

    service << "\t\t\treturn this." + repository_instance + ".save(" + class_instance + "Info);" << endl
            << "\t\t}else {" << endl
            << "\t\t\tthrow new ELException(" + attribute_name[0] + ".toString() + \" isn't in " + class_instance + " list\");" << endl
            << "\t\t}" << endl
            << "\t}" << endl
            << "}" << endl;
}