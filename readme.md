# Rester Rent Project
Rester Rent is a project in Service-Oriented Programming, Faculty of Information Technology, KMITL. This web application provide a template for restaurant's event organization service.
## Document
- Postman API document ([Link](https://documenter.getpostman.com/view/14185907/UVJeEFff))
- MongaDB design collection ([Link](https://docs.google.com/spreadsheets/d/1cJCTlVGoJx0i0lNmKZo-czlYQ2V0G2wQmDEtPqYuPM4/edit?usp=sharing))
- Wireframe ([Link](https://wireframepro.mockflow.com/view/MAzIxMwcbnb#/page/fbe793cb8bfb43e8b3ffa3287c257692))
## Workflow Utilities
- [Trello - Project Management Board](https://trello.com/b/gaNjzTMl/resterrent)

## Front-end Setup Guideline
- Use Yarn Package Manager ([Link to Yarn](https://classic.yarnpkg.com/lang/en/docs/install/#mac-stable))
- `yarn install` to install all package in package.json
- Checkout the `.env.example` and create `.env` with your environment in each variable.
```
> Your Vue.JS Live Server (example: http://localhost:8080/api)
VUE_APP_API_TARGET={HOSTNAME}:{PORT}/api
> Your Backend Server (example: http://localhost:3000)
VUE_APP_API_SERVER={HOSTNAME}:{PORT}
```
- `yarn run frontend` to start Vue.js Live Server at port 8080
- Get firebase config from [Firebase Project - Rester Rent](https://console.firebase.google.com/u/0/project/rester-rent/settings/general)
- Put firebaseConfig in `/frontend/src/config/firebaseConfig.js`
```js
export const firebaseConfig = {
    apiKey: ...,
    authDomain: ...,
    projectId: ...,
    storageBucket: ...,
    messagingSenderId: ...,
    appId: ...,
    measurementId: ...
}
```

## Backend Setup Guideline
- Checkout `application.properties.example` and create `application.properties` with your own environment. (Some where specify, you can change it.)
```
server.port= ...

server.servlet.context-path=/api

spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=... (Your MongoDB Database Name)
spring.data.mongodb.auto-index-creation=true

spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/... (Your MySQL Database Name)
spring.datasource.username= ...
spring.datasource.password= ...
```

## Color Palette
Emerald Green (Dark -> Light)
- `#034C52`
- `#015C63`
- `#017075`
<br />

Salmon (Dark -> Light)
- `#F48079`
- `#FDA898`
- `#FFC0B4`

## Backend
Use SDK 17 and Java 17
First time, should clone project from version control.
