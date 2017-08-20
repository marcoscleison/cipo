class Project {

    
    /**
     * This method accepts a closure which is essentially the DSL. Delegate the 
     * closure methods to
     * the DSL class so the calls can be processed
     */
    def static make(closure) {
        Project memoDsl = new Project()
        // any method called in closure will be delegated to the memoDsl class
        closure.delegate = memoDsl
        closure()
    }

    /**
     * Store the parameter as a variable and use it later to output a memo
     */
    
    def name(String _name){
        println("name : $_name")
     }
     
     def path(String path){ 
       println("Path: $path")
     }
     
     def task(attr,Closure closure){ 
         print("Attr ")
         print(attr)
         closure()
     }
     def methodMissing(String methodName, args) {
       
          println("undefined:$methodName")
       //def section = new Section(title: methodName, body: args[0])
       //sections << section
     }
}  

def project(Closure closure){ 

	return Project.make(closure);

}