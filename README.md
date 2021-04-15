# Data transfer over a wireless network

You will be welcomed by the SUAI-Smart-Space-Team/Wireless Team. 

## Project's goals

Research on working with LTE and masquerade. Writing an API with a device database. Implementation of the method for transferring data through the interface. Writing a program on a user device.

## Project's description 

This project is designed for users communication using various interfaces: LTE, Wi-Fi, LoRa. At this stage of the project, only data transmission via Wi-Fi and interaction with masquerade are implemented.

## Deploying the project 

Clone a repository using the command: git clone https://github.com/SUAI-Smart-Space-Team/LTE.git

#### Deployment server with ansible and masquerade
____
- You need to run the following sequence of commands to install all the necessary programs and libraries:
  - apt-get update && apt -y --force-yes install git python3-pip 
  - pip install ansible
  - apt -y --force-yes install nodejs npm
  - npm -y --force-yes install node-ansible
  - npm -y --force-yes install dgram
- You need to set up an ssh connection with the masquerade server and configure hosts file which is located in the directory "/playbooks". This stage described in detail in this video https://www.youtube.com/watch?v=SpmcZkAutjg&t=612s.
- Launch server using the command "node server [arg1] [arg2]"
  - arg1 - port which server should listen
  - arg2 - full path to the directory "/playbooks"

#### Deployment user device
____
- On Linux, the application can be run using the scrpits. To do this, first write sh /in the project directory in the terminal. compile.sh , then sh /.start.sh 
- On Windows, you can also run the application through a script. To do this, you need to register compile in the console.bat, then start. bat. 
- __On Windows, problems may occur if the JAVA_HOME variable is not registered in the system. In this case, it is necessary in the compile file.bat specify the path to javac.(bold)__

#### Deployment FrontBack
____
- In the command line, write the commands to install node js and npm:
  - apt-get update
  - apt install nodejs
  - apt install npm
- Next, you need to create the package files.json and package-lock.json, and initialize the project. To do this, run the following command: npm install
- Download the MySQL-server docker image from DockerHub using the following command: docker pull nikitallo/db: latest
- Create and run a container from an image using the command: docker run-name myDB -it nikitallo/db:latest
- Create a database on the deployed server using the command: docker exec -it myDB mysql-uroot -prootroot-e "CREATE DATABASE myDB"
- Import the database structure from the file "myDB.sql" using the following command: docker exec -i myDB mysql -uroot -prootroot myDB < myDB. sql
- When all the dependencies and databases are installed, you can run the project using the command: "node server.js [arg1] [arg2] [arg3]"
  - arg1 - the Ip address of the machine with ansible;
  - arg2 - the machine port with ansible;
  - arg3 - the terminal device machine port.
