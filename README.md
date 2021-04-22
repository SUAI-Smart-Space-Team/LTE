# Data transfer over a wireless network

You will be welcomed by the SUAI-Smart-Space-Team/Wireless Team. 

## Project's goals

Research on working with LTE and masquerade. Writing an API with a device database. Implementation of the method for transferring data through the interface. Writing a program on a user device.

## Project's description 

This project is designed for users communication using various interfaces: LTE, Wi-Fi, LoRa. At this stage of the project, only data transmission via Wi-Fi and interaction with masquerade are implemented.

![Minimal System](https://user-images.githubusercontent.com/57037988/114868388-85625480-9dfe-11eb-87dc-4d1321422058.png)

- The user sends a message that specifies the Device ID, data and through which interface to transmit it;
- The API checks the ID data in the database, the interfaces available to it, and takes its IP;
- If all the data is correct, API send message via the selected interface;
- The user receives the message.

## Deploying the project 

### Deployment user device

Link to the repository with instructions: https://github.com/SUAI-Smart-Space-Team/WHN-UserDevice

____

### Deployment FrontBack

Link to the repository with instructions: https://github.com/SUAI-Smart-Space-Team/WHN-Front-Back

