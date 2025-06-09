# Install SDK
    Download SDK 9.x
    ASP.NET Core Runtime 9.0.5
# Install IDE Visual studion 2022
    ```bash
        https://visualstudio.microsoft.com/thank-you-downloading-visual-studio/?sku=Enterprise&channel=Release&version=VS2022&source=VSLandingPage&cid=2030&passive=false
    ```
Enterprise: 
    ```
    VHF9H-NXBBB-638P6-6JHCY-88JWH
    ```
    
# Install HQTCSDL (My Sql ,SQL server, ) 
# Install Docker 
    ```dockerfile
        https://www.docker.com/products/docker-desktop/
    ```
# Install SQL server -> Docker 
    ```terraform
        https://learn.microsoft.com/en-us/sql/linux/quickstart-install-connect-docker?view=sql-server-ver16&t    abs=cli&pivots=cs1-bash
    ```
# Or install Mysql 
1. Download image docker
    ```bash
        docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:tag
    ```
2. run container mysql 
    ``` bash
        docker run -it --network some-network --rm mysql mysql -hsome-mysql -uexample-user -p
    ```
    
3. Try connect SQL server:
    Install extension vscode: search : database 
    CREATE database DemoNet9 ;

    
    
    
    