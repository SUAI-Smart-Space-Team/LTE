# Data transfer over a wireless network

You will be welcomed by the SUAI-Smart-Space-Team/Wireless Team. 

## Objective of the project

Research on working with LTE and masquerade. Writing an API with a device database. Implementation of the method for transferring data through the interface. Writing a program on a user device.

## Description of the project 

This project is designed for user communication using various interfaces: LTE, Wi-Fi, LoRa. At this stage of the project, only data transmission via Wi-Fi and interaction with masquerade are implemented.

## Deploying the project 

#### Start the server with ansible and masquerade
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

#### Launching a user device
____
- On Linux, the application can be run using the scrpits. To do this, first write sh /in the project directory in the terminal. compile.sh , then sh /.start.sh 
- On Windows, you can also run the application through a script. To do this, you need to register compile in the console.bat, then start. bat. 
- On Windows, problems may occur if the JAVA_HOME variable is not registered in the system. In this case, it is necessary in the compile file.bat specify the path to javac.(bold)
