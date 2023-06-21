function HomeContent() {
    console.log("HomeContent Component")

    return (
        <div className="content">
            <div id="home" className="section">
                <div className="container">
                    <h2>Fuel Up Your Ride</h2>
                    <p>Welcome to our gas station website. We provide high-quality fuel and services to meet all your
                        vehicle needs.Keep your engine running smoothly with our premium gas</p>
                </div>
            </div>

            <div id="customer" className="section bg-light">
                <div className="container">
                    <h2>Services</h2>
                    <p>Our gas station offers special discounts and loyalty programs for our valued customers. Join
                        today and enjoy exclusive benefits.</p>
                </div>
            </div>

            <div id="employee" className="section">
                <div className="container">
                    <h2>Gallery</h2>
                    <p>Our dedicated team of professionals ensures smooth operations and excellent customer service at
                        our gas station.</p>
                </div>
            </div>

            <div id="item" className="section bg-light">
                <div className="container">
                    <h2>About Us</h2>
                    <p>Explore our wide range of items available at the convenience store, including snacks, beverages,
                        and automotive accessories.</p>
                </div>
            </div>

            <div id="transaction" className="section">
                <div className="container">
                    <h2>Contact Us</h2>
                    <p>Conveniently pay for your fuel and purchases at our gas station with various payment options,
                        including cash, cards, and mobile wallets.</p>
                </div>
            </div>

        </div>

    );
}

export default HomeContent;