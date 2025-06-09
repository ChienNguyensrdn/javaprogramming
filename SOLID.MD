# Nguyên tắc SOLID 
## S is single responsibility principle (SRP)
    Một class chỉ nên giữ 1 trách nhiệm duy nhất (Chỉ có thể sửa đổi class với 1 lý do duy nhất)

    ```csharp
         public class Employee
        {
            public int Employee_Id { get; set; }
            public string Employee_Name { get; set; }
    
            /// <summary>
            /// This method used to insert into employee table
            /// </summary>
            /// <param name="em">Employee object</param>
            /// <returns>Successfully inserted or not</returns>
            public bool InsertIntoEmployeeTable(Employee em)
            {
                // Insert into employee table.
                return true;
            }
            /// <summary>
            /// Method to generate report
            /// </summary>
            /// <param name="em"></param>
            public void GenerateReport(Employee em)
            {
                // Report generation with employee data using crystal report.
            }
        }
    ```
    
## O stands for open/closed principle (OCP)
    Có thể mở rộng 1 class, nhưng không được sửa đổi bên trong class đó

    ```csharp
        public class ReportGeneration
        {
            /// <summary>
            /// Report type
            /// </summary>
            public string ReportType { get; set; }
        
            /// <summary>
            /// Method to generate report
            /// </summary>
            /// <param name="em"></param>
            public void GenerateReport(Employee em)
            {
                if (ReportType == "CRS")
                {
                     // Report generation with employee data in Crystal Report.
                }
                if (ReportType == "PDF")
                {
                    // Report generation with employee data in PDF.
                }
             }
         }
    ```
    
## L Liskov substitution principle (LSP)
    Class con không nên phá vỡ các định nghĩa và hành vi của class cha.
    ```csharp
        public abstract class Employee
        {
            public string Empcode {get;set;}
            
            public string FristName {get;set;}
            
            public string LastName {get;set;}
            
            public virtual string GetFullname()
            {
                return $"{FirstName} {LastName}";
            }
        }
        
        public class Developer : Employee
        {
            public override string GetFullname()
            {
                return $"Developer - {FirstName} {LastName}";
            }
        }
        
        public class BotDeveloper: Employee{
                public override string GetFullname()
                {
                     throw new NotImplementedException();
                }
        }
        
        List<Employee> employeeList = new List<Employee>();
        employeeList.Add(new Developer());
        employeeList.Add(new BotDeveloper());
        foreach (Employee e in employeeList)
        {
            e.GetFullname();
        }

    ```
    
## I interface segregation principle (ISP)
    Thay vì dùng 1 interface lớn, ta nên tách thành nhiều interface nhỏ, với các mục đích khác nhau.
    public interface IExportReport
    {
        void ExportExcelReport();

         void ExportPdfReport();
    }
    //?

## D Dependency injection principle (DIP)

    Giảm sự phụ thuộc bằng cách inject (tiêm) các class phụ thuộc vào class dùng class đó.

    Dependency là những module cấp thấp, hoặc các service gọi từ bên ngoài. Với cách code thông thường, các module cấp cao sẽ gọi các module cấp thấp. Module cấp cao sẽ phụ thuộc và module cấp thấp, điều đó tạo ra các dependency.