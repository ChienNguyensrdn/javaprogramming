package Buoi2;

public class Employee {
    //default : private 
    //Một class chỉ nên giữ 1 trách nhiệm duy nhất (Chỉ có thể sửa đổi class với 1 lý do duy nhất)
    //CRUD... (Create, update, delete --> CSDL )
    String EmployeeCode;
    String FullName ;
    //getter, setter 
    public String getEmployeeCode(){
        return this.EmployeeCode;
    }
    public void setEmployeeCode (String _code){
        this.EmployeeCode = _code;
    }
    public String getFullName(){
        return this.FullName;
    }
    public void setFullName (String _fullName){
        this.FullName = _fullName;
    }
    public void SaveEmployee(Employee employee){
        //logic xu ly lien quan den luu data --> csdl
    }
    
}
