import {useEffect, useState} from "react";

function EmployeesContent() {

    const [employees, setEmployees] = useState([])

    let jwt = localStorage.getItem("jwt")
    useEffect(() => {
        fetch(`http://localhost:8080/gas_station/employees`,
            {
                method: "GET",
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": "Bearer " + jwt
                }
            })
            .then((response) => response.json())
            .then((employees) => {
                console.log(employees);
                setEmployees(employees)
            })
            .catch((error) => console.log(error));


    }, []);



    return (
        <div id={"employee-container"}>
            <div className="container">
                <h1 className="text-center mb-4">Employee Management</h1>
                <div className="card">
                    <div className="card-body">
                        <form id="employee-form">

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
                                <label htmlFor="employeeType" className="form-label">Employee Type:</label>
                                <input type="text" className="form-control" id="employeeType" name="employeeType"
                                       required/>
                            </div>
                            <div className="mb-3">
                                <label htmlFor="hireDateStart" className="form-label">Hire Date Start:</label>
                                <input type="text" className="form-control" id="hireDateStart" name="hireDateStart"
                                       required/>
                            </div>
                            <div className="mb-3">
                                <label htmlFor="endDateStart" className="form-label">End Date Start:</label>
                                <input type="text" className="form-control" id="endDateStart" name="endDateStart"
                                       required/>
                            </div>
                            <div className="mb-3">
                                <label htmlFor="salaryPerMonth" className="form-label">Salary Per Month:</label>
                                <input type="text" className="form-control" id="salaryPerMonth" name="salaryPerMonth"
                                       required/>
                            </div>

                            <button type="submit" className="btn btn-primary">Create</button>
                            <button type="submit" className="btn btn-primary">Update</button>
                            <button type="reset" className="btn btn-primary">Delete</button>
                            <button type="search" className="btn btn-primary">Search</button>
                        </form>
                    </div>
                </div>

                <div className="alert alert-success d-none" id="success-alert" role="alert">
                    Employee created/updated/deleted successfully!
                </div>
            </div>
            <div className="card">
                <div className="card-body">
                    <h2 className="card-title">Employee List</h2>
                    <div className="table-responsive">
                        <table className="table table-striped">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Email</th>
                                <th>Password</th>
                                <th>Salary Per Month</th>
                            </tr>
                            </thead>
                            <tbody id="employee-table">
                            {employees.map((employee) => (
                                <tr key={employee.id}>
                                    <td>{employee.id}</td>
                                    <td>{employee.firstName}</td>
                                    <td>{employee.lastName}</td>
                                    <td>{employee.email}</td>
                                    <td>{employee.password}</td>
                                    <td>{employee.salaryPerMonth}</td>
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

export default EmployeesContent;