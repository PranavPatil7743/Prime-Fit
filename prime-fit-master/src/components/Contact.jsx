import React from 'react'
import Navbar from './Navbar'
import Footer from './Footer'

const Contact = () => {
    return (
        <main>
            <Navbar />
            <section className="contact">
                <h1 className="heading-section">Contact</h1>
                <div className="container">
                    <article className="contact-section">
                        <strong className="contact-heading">Location</strong>
                        <p className="contact-paragraph">
                        216, Main Road, Sangli, IN-416416
                        </p>
                    </article>
                    <article className="contact-section">
                        <strong className="contact-heading">Call</strong>
                        <p className="contact-paragraph">
                            +91 9021521008 <br/>
                            +91 9130039556
                        </p>
                    </article>
                    <article className="contact-section">
                        <strong className="contact-heading">Email</strong>
                        <p className="contact-paragraph">
                            contact@primefit.com
                        </p>
                    </article>
                </div>
            </section>
            <Footer />
        </main>
    )
}

export default Contact