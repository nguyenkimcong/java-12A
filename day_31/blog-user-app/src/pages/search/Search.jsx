import React from "react";
import { Helmet } from "react-helmet";

function Search() {
    return (
        <>
            <Helmet>
                <title>Tìm kiếm</title>
            </Helmet>
            <main className="main">
                <header className="page-header">
                    <h1>Search</h1>
                    <div className="post-description">Tìm kiếm bài viết</div>
                    <div className="post-meta"></div>
                </header>
                <div id="searchbox">
                    <input
                        id="searchInput"
                        placeholder="Tìm kiếm bài viết"
                        autocomplete="off"
                    />
                    <ul id="searchResults"></ul>
                </div>
            </main>
        </>
    );
}

export default Search;
