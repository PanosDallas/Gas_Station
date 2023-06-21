function Contacts() {

    return (
        <div id={"contact-container"}>
            <div className="container">
                <h1 className="text-center mb-4">Contact</h1>
                <div className="card">
                    <div className="card-body">
                        <form id="contact-form">

                            <div className="mb-3">
                                <label htmlFor="name" className="form-label">Name:</label>
                                <input type="text" className="form-control" id="name" name="name" required/>
                            </div>

                            <div className="mb-3">
                                <label htmlFor="email" className="form-label">Email:</label>
                                <input type="email" className="form-control" id="email" name="email" required/>
                            </div>

                            <div className="mb-3">
                                <label htmlFor="message" className="form-label">Message:</label>
                                <input type="text" className="form-control" id="message" name="message" required/>
                            </div>

                            <button type="submit" className="btn btn-primary">SUBMIT</button>

                        </form>
                    </div>
                </div>

                <div className="alert alert-success d-none" id="success-alert" role="alert">
                    Contact updated successfully!
                </div>
            </div>
            <div className="card">
                <div className="card-body">
                    <h2 className="card-title">Contact List</h2>
                    <div className="table-responsive">
                        <table className="table table-striped">
                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Message</th>


                            </tr>
                            </thead>
                            <tbody id="contact-table">
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Contacts;