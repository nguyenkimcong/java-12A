import React from "react";
import { Link } from "react-router-dom";

function Header() {
    return (
        <header className="header">
            <nav className="nav">
                <div className="logo">
                    <Link to={"/"}>Kong.dev</Link>
                </div>
                <ul id="menu">
                    <li>
                        <Link to={"/search"}>Search</Link>
                    </li>
                    <li>
                        <Link to={"/tags"}>Tags</Link>
                    </li>
                </ul>
            </nav>
        </header>
    );
}

export default Header;
