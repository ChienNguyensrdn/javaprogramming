# Install Docker 
    ```dockerfile
        https://www.docker.com/products/docker-desktop/
    ```
# Install hệ quản trị cơ sở dữ liệu trên docker 
    ```bash
        docker pull mcr.microsoft.com/mssql/server:2022-latest
    ```
    
# Run the container
    ```bash
        docker run -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=Aa@123456" -p 1433:1433 --name sql1 --hostname sql1  -d  mcr.microsoft.com/mssql/server:2022-latest
    ```
    
# Install JDK 
    ```http
        https://www.oracle.com/java/technologies/downloads/
    ```

# Install IDE: 
    ```vscode
        https://code.visualstudio.com/download
    ```
    
    ```intelj
        https://www.jetbrains.com/idea/
    ```