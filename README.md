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
- You need to set up an ssh connection with the masquerade server. This is described in detail in this video https://www.youtube.com/watch?v=SpmcZkAutjg&t=612s.
