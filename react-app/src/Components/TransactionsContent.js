function TransactionsContent() {

    return (
        <div id={"transaction-container"}>
            <div className="container">
                <h1 className="text-center mb-4">Transaction Management</h1>
                <div className="card">
                    <div className="card-body">
                        <form id="transaction-form">

                            <div className="mb-3">
                                <label htmlFor="date" className="form-label">Date:</label>
                                <input type="text" className="form-control" id="date" name="date" required/>
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
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default TransactionsContent;