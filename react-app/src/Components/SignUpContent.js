import {useEffect, useState} from "react";
import AuthorizationService from "../services/AuthorizationService";


function SignUpContent() {

    let [loginForm, setLoginForm] = useState({"email": "", "password": ""});
    let [registrationForm, setRegistrationForm] = useState({"email": "", "password": "", "confirmPassword": ""});

    const handleLoginFormChange = (e) => {
        let copyOfLoginForm = {...loginForm};
        copyOfLoginForm[e.target.name] = e.target.value;
        setLoginForm(copyOfLoginForm);
    }



    const setTokenToLocalStorage = (data) => {
        console.log(data.token);
        localStorage.setItem("jwt", data.token);
    }
    const handleError = (error) => {
        console.log(error);
    }

    const handleLoginSubmit = (e) => {
        e.preventDefault();

        // Encode the username and password in the Base64 auth format
        AuthorizationService
            .login(loginForm.email, loginForm.password)
            .then(setTokenToLocalStorage)
            .catch(handleError);

    }


    return (
        // create with css grid 2 forms side-by-side for login and register
        <div className="authorization-container">

            <div className="signUp-form">
                <h2>Sign-Up</h2>
                <form className={"form-group"}>
                    <label htmlFor="signUp-email">Username</label>
                    <input type="text" id="signUp-email" name="email" placeholder="Username" required></input>
                    <label htmlFor="email">Email</label>
                    <input type="text" id="email" name="email" onChange={handleLoginFormChange} value={loginForm.email}
                           placeholder="Email" required></input>
                    <label htmlFor="password">Password</label>
                    <input type="password" id="password" name="password" placeholder="Password" required></input>
                    <label htmlFor="confirm-password">Confirm Password</label>
                    <input type="password" id="confirm-password" name="confirmPassword" placeholder="Confirm Password"
                           required></input>
                    <button type="submit">Sign-Up</button>
                </form>
            </div>
        </div>

    );
}

export default SignUpContent;