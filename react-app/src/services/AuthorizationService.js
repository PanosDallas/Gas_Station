const AuthorizationService = {



    login: (email, password) => {
        const basicAuth = btoa(`${email}:${password}`);


        return fetch(`http://localhost:8080/gas_station/auth/login`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Basic ${basicAuth}`
            }
        })
            .then((response) =>  response.json());
    }

}

export default AuthorizationService;