# Rester Rent Project
Rester Rent is a project in Service-Oriented Programming, Faculty of Information Technology, KMITL. This web application provide a template for restaurant's event organization service.
## Document
- Postman API document ([Link](https://documenter.getpostman.com/view/14185907/UVJeEFff))
- MongaDB design collection ([Link](https://docs.google.com/spreadsheets/d/1cJCTlVGoJx0i0lNmKZo-czlYQ2V0G2wQmDEtPqYuPM4/edit?usp=sharing))
## Frontend
- Wireframe ([Link](https://wireframepro.mockflow.com/view/MAzIxMwcbnb#/page/fbe793cb8bfb43e8b3ffa3287c257692))
## Workflow Utilities
- [Trello - Project Management Board](https://trello.com/b/gaNjzTMl/resterrent)

## Front-end Setup Guideline
- Use Yarn Package Manager ([Link to Yarn](https://classic.yarnpkg.com/lang/en/docs/install/#mac-stable))
- `yarn install` to install all package in package.json
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
