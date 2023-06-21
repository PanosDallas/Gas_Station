import {Link} from "react-router-dom";

function Header(){

    return (

        <div>
            <nav className="navbar background">
                <ul className="nav-list">
                    <div className="logo">
                        <img className="logo"
                             src="https://previews.agefotostock.com/previewimage/medibigoff/50f97e33f6cde1b3672049545da08fc9/esy-057042716.jpg"
                             width="60" height="60"/>
                    </div>
                    <h1>Welcome to Our Gas Station</h1>
                    <li><Link to="">Home</Link></li>
                    <li><Link to="customers">Customer</Link></li>
                    <li><Link to="employees">Employee</Link></li>
                    <li><Link to="items">Item</Link></li>
                    <li><Link to="transactions">Transaction</Link></li>
                    <li><Link to="LoginContent">Login</Link></li>
                    <li><Link to="SignUpContent">SignUp</Link></li>
                </ul>
                
            </nav>

        </div>

    );

}
export default Header;