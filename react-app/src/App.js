import './App.css';
import './Assets/default.css'
import Header from "./Components/Header";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import PostContent from "./Components/PostContent";
import Footer from "./Components/Footer";
import CustomersContent from "./Components/Customers";
import HomeContent from "./Components/HomeContent";
import EmployeesContent from "./Components/Employees";
import Items from "./Components/Items";
import TransactionsContent from "./Components/TransactionsContent";
import 'bootstrap/dist/css/bootstrap.css';
import LoginContent from "./Components/LoginContent";
import SignUpContent from "./Components/SignUpContent";



function App() {
  return (
    <div className="App">
        <BrowserRouter>
      <Header/>


            <Routes>
                <Route index element ={<HomeContent/>}/>
                <Route path ="/customers" element ={<CustomersContent/>}/>
                <Route path ="/employees" element ={<EmployeesContent/>}/>
                <Route path ="/items" element ={<Items/>}/>
                <Route path ="/transactions" element ={<TransactionsContent/>}/>
                <Route path ="/LoginContent" element ={<LoginContent/>}/>
                <Route path ="/SignUpContent" element ={<SignUpContent/>}/>
            </Routes>

        <Footer/>
        </BrowserRouter>
      {/*<header className="App-header">*/}
      {/*  <img src={logo} className="App-logo" alt="logo" />*/}
      {/*  <p>*/}
      {/*    Edit <code>src/App.js</code> and save to reload.*/}
      {/*  </p>*/}
      {/*  <a*/}
      {/*    className="App-link"*/}
      {/*    href="https://reactjs.org"*/}
      {/*    target="_blank"*/}
      {/*    rel="noopener noreferrer"*/}
      {/*  >*/}
      {/*    Learn React*/}
      {/*  </a>*/}
      {/*</header>*/}
    </div>

  );
}

export default App;
