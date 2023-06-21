import {useEffect, useState} from "react";

function CustomersContent() {

    const [customers, setCustomers] = useState([])

    let jwt = localStorage.getItem("jwt")
    useEffect(() => {
        fetch(`http://localhost:8080/gas_station/customers`,
            {
                method: "GET",
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": "Bearer " + jwt
                }
            })
            .then((response) => response.json())
            .then((customers) => {
                console.log(customers);
                setCustomers(customers)
            })
            .catch((error) => console.log(error));


    }, []);


    return (

        <div id={"customers-container"}>
            <div className="container">
                <h1 className="text-center mb-4">Customer Management</h1>
                <div className="card">
                    <div className="card-body">
                        <form id="customer-form">

                            <div className="mb-3">
                                <label htmlFor="firstName" className="form-label">First Name:</label>
                                <input type="text" className="form-control" id="firstName" name="firstName" required/>
                            </div>

                            <div className="mb-3">
                                <label htmlFor="lastName" className="form-label">Last Name:</label>
                                <input type="text" className="form-control" id="lastName" name="lastName" required/>
                            </div>

                            <div className="mb-3">
                                <label htmlFor="email" className="form-label">Email:</label>
                                <input type="email" className="form-control" id="email" name="email" required/>
                            </div>

                            <div className="mb-3">
                                <label htmlFor="password" className="form-label">Password:</label>
                                <input type="password" className="form-control" id="password" name="password" required/>
                            </div>

                            <div className="mb-3">
                                <label htmlFor="cardNumber" className="form-label">Card Number:</label>
                                <input type="text" className="form-control" id="cardNumber" name="cardNumber" required/>
                            </div>

                            <button type="submit" className="btn btn-primary">Create</button>
                            <button type="submit" className="btn btn-primary">Update</button>
                            <button type="reset" className="btn btn-primary">Delete</button>
                            <button type="search" className="btn btn-primary">Search</button>
                        </form>
                    </div>
                </div>

                <div className="alert alert-success d-none" id="success-alert" role="alert">
                    Customer created/updated successfully!
                </div>
            </div>
            <div className="card">
                <div className="card-body">
                    <h2 className="card-title">Customer List</h2>
                    <div className="table-responsive">
                        <table className="table table-striped">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Email</th>
                                <th>Password</th>
                                <th>Card Number</th>
                            </tr>
                            </thead>
                            <tbody id="customer-table">
                            {customers.map((customer) => (
                                <tr key={customer.id}>
                                    <td>{customer.id}</td>
                                    <td>{customer.firstName}</td>
                                    <td>{customer.lastName}</td>
                                    <td>{customer.email}</td>
                                    <td>{customer.password}</td>
                                    <td>{customer.cardNumber}</td>
                                </tr>
                            ))}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default CustomersContent;