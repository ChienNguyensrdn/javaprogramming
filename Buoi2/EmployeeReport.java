package Buoi2;

import java.lang.module.ModuleDescriptor.Exports;
import java.util.List;

public class EmployeeReport {
    Double SalaryAvg;
    Double SoNamLamViec;
    String Type;
    public void Export(List<Employee> employees){
        //Report /....
        if (Type == "Excel"){
            //logic export Excel
        }
        if (Type =="PDF"){
            //logic export Excel
        }
    }
   
}
