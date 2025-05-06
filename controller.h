#include <iostream>
#include <vector>
#include <fstream>

void create_controller(string package, string class_name, vector<string> attributes) {
    class_name[0] = toupper(class_name[0]);
    string class_instance = class_name;
    class_instance[0] = tolower(class_instance[0]);
    string service_class = class_name + "Service";
    string service_instance = class_instance + "Service";
    vector<string> attribute_name = get_attribute_name(attributes);
    ofstream controller("controller/" + class_name + "Controller.java");

    controller << "package " + package + ".controller;" << endl
               << endl
               << "import java.util.List;" << endl
               << endl
               << "import " + package + ".model." + class_name + ";" << endl
               << "import " + package + ".service." + class_name + "Service;" << endl
               << endl
               << "import org.springframework.http.ResponseEntity;" << endl
               << "import org.springframework.web.bind.annotation.*;" << endl
               << endl
               << "@RestController" << endl
               << "@RequestMapping(\"/\")" << endl
               << "public class " + class_name + "Controller {" << endl
               << "\tfinal " + service_class + " " + service_instance + ";" << endl
               << endl
               
               // controller
               << "\tpublic " + class_name + "Controller(" + service_class + " " + service_instance + ") {" << endl
               << "\t\tthis." + service_instance + " = " + service_instance + ";" << endl
               << "\t}" << endl
               << endl

               // POST
               << "\t/*"<< endl
               << "\t * use " + class_name + " service" << endl
               << "\t */" << endl
               << "\t@PostMapping(\"/add" + class_name + "\")" << endl
               << "\tpublic ResponseEntity<" + class_name + "> " + "add" + class_name + "(@RequestBody " + class_name + " new" + class_name + ") {" << endl
               << "\t\treturn ResponseEntity.ok(this." + service_instance + ".add" + class_name + "(new" + class_name + "));" << endl
               << "\t}" << endl
               << endl

               // GET
               << "\t@GetMapping(\"/get" + class_name + "List\")" << endl
               << "\tpublic ResponseEntity<List<" + class_name + ">> get" + class_instance + "List() {" << endl
               << "\t\treturn ResponseEntity.ok(this." + service_instance + ".get" + class_name + "List());" << endl
               << "\t}" << endl
               << endl

               // DELETE
               << "\t@DeleteMapping(\"/delete" + class_name + "/{" + attribute_name[0] + "}\")" << endl
               << "\tpublic ResponseEntity<String> delete" + class_name + "(@PathVariable " + attributes[0] + ") {" << endl
               << "\t\treturn ResponseEntity.ok(this." + service_instance + ".delete" + class_name + "(" + attribute_name[0] + "));" << endl
               << "\t}" << endl
               << endl

               // UPDATE
               << "\t@PutMapping(\"/update" + class_name + "/{" + attribute_name[0] + "}\")" << endl
               << "\tpublic ResponseEntity<" + class_name + "> " + "update" + class_name + "(@PathVariable " + attributes[0] + ", @RequestBody " + class_name + " new" + class_name + "Info) {" << endl
               << "\t\treturn ResponseEntity.ok(this." + service_instance + ".update" + class_name + "(" + attribute_name[0] + ", new" + class_name + "Info" + "));" << endl
               << "\t}" << endl
               << "}" << endl;
}