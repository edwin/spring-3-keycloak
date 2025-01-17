# Spring Boot 3, Spring Security, and Keycloak

## Purpose
A sample java code to demonstrate a Spring Boot 3 integration with Keycloak 17. It utilize Keycloak login page, and fetch a user's attribute based on Keycloak user profile. 

## Version
- Spring Boot 3.0.4
- Keycloak 17
- Red Hat OpenJDK 17

## Testing Login and Logout Steps
1. Start Keycloak server locally
1. Create a realm
1. Create a client
1. In client, configure:          
    - root url: http://localhost:8081
    - home url: http://localhost:8081/login
    - valid redirect url: *
    - valid post logout redirect URIs: * 
    - web origin: +

1. Goto localhost:8081/login
1. Keyin username/password
1. Goto localhost:8081/logout, follow the steps
1. Expectation is the logout will redirect back to localhost:8081/login

## Screenshots
Keycloak User Profile

![User Profile](images/sboot-keycloak-01.png)

JSON Response reading Keycloak Profile

![JSON](images/sboot-keycloak-02.png)

## Blog Post
Explanation of this code can be seen on below `Red Hat Developer` article, 
```
https://developers.redhat.com/articles/2023/07/24/how-integrate-spring-boot-3-spring-security-and-keycloak
```

## Disclaimer
```
This code is provided "as is" without any guarantee whatsoever. 
Feel free to fork, add, remove, change, or do whatever you want with it. 
```