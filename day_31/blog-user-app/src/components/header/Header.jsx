import React from "react";
import { Link, NavLink } from "react-router-dom";

function Header() {
    return (
        <header className="header">
            <nav className="nav">
                <div className="logo">
                    <Link to={"/"}>Kong.dev</Link>
                </div>
                <ul id="menu">
                    <li>
                        <NavLink to={"/search"}>Search</NavLink>
                    </li>
                    <li>
                        <NavLink to={"/tags"}>Tags</NavLink>
                    </li>
                </ul>
            </nav>
        </header>
    );
}

export default Header;
