# Data transfer over a wireless network

You will be welcomed by the SUAI-Smart-Space-Team/Wireless Team. 

## Objective of the project

Research on working with LTE and masquerade. Writing an API with a device database. Implementation of the method for transferring data through the interface. Writing a program on a user device.

## Description of the project 

This project is designed for user communication using various interfaces: LTE, Wi-Fi, LoRa. At this stage of the project, only data transmission via Wi-Fi and interaction with masquerade are implemented.

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
- You need to set up an ssh connection with the masquerade server and configure hosts file that is located in the directory /playbooks. This is described in detail in this video https://www.youtube.com/watch?v=SpmcZkAutjg&t=612s.
- Launch server using the command "node server [arg1] [arg2]"
  - arg1 - port on which the server listening
  - arg2 - full path to the directory /playbooks

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
- Next, you need to create the package files.json and package-lock.json, and initialize the project. To do this, run the following command:
npm install
-
- When all the dependencies and databases are installed, you can run the project using the command: "node server.js [arg1] [agr2] [agr3]"
  - arg1 is the Ip address of the machine with ansible;
  - agr2 is the machine port with ansible;
  - agr3 is the terminal device machine port.
