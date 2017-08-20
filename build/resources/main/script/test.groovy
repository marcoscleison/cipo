import Project

Project.make {
    name 'Nirav Assar'
    path '/home/cipo'
   
   task(id:1,acl:"2"){
       println("Closure id 1")
       task(id:2, name2:"jesef"){
          println("Closure id 1")
       }
       
       xml()
    }
}