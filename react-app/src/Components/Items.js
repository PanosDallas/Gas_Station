import {useEffect, useState} from "react";


function Items() {


    const [items, setItems] = useState([])

    let jwt = localStorage.getItem("jwt")
    useEffect(() => {
        fetch(`http://localhost:8080/gas_station/items`,
            {
                method: "GET",
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": "Bearer " + jwt
                }
            })
            .then((response) => response.json())
            .then((items) => {
                console.log(items);
                setItems(items)
            })
            .catch((error) => console.log(error));


    }, []);


    return (
        <div id={"item-container"}>
            <div className="container">
                <h1 className="text-center mb-4">Item Management</h1>
                <div className="card">
                    <div className="card-body">
                        <form id="item-form">

                            <div className="mb-3">
                                <label htmlFor="code" className="form-label">Code:</label>
                                <input type="text" className="form-control" id="code" name="code" required/>
                            </div>

                            <div className="mb-3">
                                <label htmlFor="description" className="form-label">Description:</label>
                                <input type="text" className="form-control" id="description" name="description" required/>
                            </div>

                            <div className="mb-3">
                                <label htmlFor="itemType" className="form-label">Item Type:</label>
                                <input type="text" className="form-control" id="itemType" name="itemType" required/>
                            </div>

                            <div className="mb-3">
                                <label htmlFor="price" className="form-label">Price:</label>
                                <input type="text" className="form-control" id="price" name="price" required/>
                            </div>

                            <div className="mb-3">
                                <label htmlFor="cost" className="form-label">Cost:</label>
                                <input type="text" className="form-control" id="cost" name="cost" required/>
                            </div>


                            <button type="submit" className="btn btn-primary">Create</button>
                            <button type="submit" className="btn btn-primary">Update</button>
                            <button type="reset" className="btn btn-primary">Delete</button>
                            <button type="search" className="btn btn-primary">Search</button>
                        </form>
                    </div>
                </div>

                <div className="alert alert-success d-none" id="success-alert" role="alert">
                    Item created/updated/deleted successfully!
                </div>
            </div>
            <div className="card">
                <div className="card-body">
                    <h2 className="card-title">Item List</h2>
                    <div className="table-responsive">
                        <table className="table table-striped">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Code</th>
                                <th>Description</th>
                                <th>Item Type</th>
                                <th>Price</th>
                                <th>Cost</th>
                            </tr>
                            </thead>
                            <tbody id="item-table">
                            {items.map((item) => (
                                <tr key={item.id}>
                                    <td>{item.id}</td>
                                    <td>{item.code}</td>
                                    <td>{item.description}</td>
                                    <td>{item.itemType}</td>
                                    <td>{item.price}</td>
                                    <td>{item.cost}</td>
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

export default Items;