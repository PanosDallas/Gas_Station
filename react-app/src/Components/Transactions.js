import {useEffect, useState} from "react";

function Transactions() {


    const [transactions, setTransactions] = useState([])

    let jwt = localStorage.getItem("jwt")
    useEffect(() => {
        fetch(`http://localhost:8080/gas_station/transactions`,
            {
                method: "GET",
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": "Bearer " + jwt
                }
            })
            .then((response) => response.json())
            .then((transactions) => {
                console.log(transactions);
                setTransactions(transactions)
            })
            .catch((error) => console.log(error));


    }, []);


    return (
        <div id={"transaction-container"}>
            <div className="container">
                <h1 className="text-center mb-4">Transaction Management</h1>
                <div className="card">
                    <div className="card-body">
                        <form id="transaction-form">

                            <div className="mb-3">
                                <label htmlFor="date" className="form-label">Date:</label>
                                <input type="date" className="form-control" id="date" name="date" required/>
                            </div>

                            <div className="mb-3">
                                <label htmlFor="paymentMethod" className="form-label">Payment Method:</label>
                                <input type="text" className="form-control" id="paymentMethod" name="paymentMethod" required/>
                            </div>

                            <div className="mb-3">
                                <label htmlFor="totalValue" className="form-label">Total Value:</label>
                                <input type="text" className="form-control" id="totalValue" name="totalValue" required/>
                            </div>

                            <button type="submit" className="btn btn-primary">Create</button>
                            <button type="submit" className="btn btn-primary">Update</button>
                            <button type="reset" className="btn btn-primary">Delete</button>
                            <button type="search" className="btn btn-primary">Search</button>
                        </form>
                    </div>
                </div>

                <div className="alert alert-success d-none" id="success-alert" role="alert">
                    Transaction created/updated/deleted successfully!
                </div>
            </div>
            <div className="card">
                <div className="card-body">
                    <h2 className="card-title">Transaction List</h2>
                    <div className="table-responsive">
                        <table className="table table-striped">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Date</th>
                                <th>Payment Method</th>
                                <th>Total Value</th>

                            </tr>
                            </thead>
                            <tbody id="transaction-table">
                            {transactions.map((transaction) => (
                                <tr key={transaction.id}>
                                    <td>{transaction.id}</td>
                                    <td>{transaction.date}</td>
                                    <td>{transaction.paymentMethod}</td>
                                    <td>{transaction.totalValue}</td>
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

export default Transactions;