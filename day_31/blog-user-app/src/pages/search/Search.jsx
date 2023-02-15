import React, { useState } from "react";
import { Helmet } from "react-helmet";
import { useLazySearchBlogQuery } from "../../app/services/blog.api";
import { toast } from "react-toastify";

function Search() {
    const [term, setTerm] = useState("");
    const [blogs, setBlogs] = useState([]);
    const [searchBlog] = useLazySearchBlogQuery();

    const handleSearch = async (e) => {
        if (e.key === "Enter") {
            if (term.trim() === "") {
                toast.error("Từ khóa không được để trống")
                return;
            }
            try {
                let { data } = await searchBlog(term);
                setBlogs(data);
            } catch (error) {
                console.log(error);
            }
        }
    };
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
                        value={term}
                        onChange={(e) => setTerm(e.target.value)}
                        onKeyDown={(e) => handleSearch(e)}
                    />
                    <ul id="searchResults">
                        {blogs.map((b) => (
                            <li class="post-entry">
                                <header class="entry-header">
                                    {b.title}
                                </header>
                                <a
                                    href={`/blogs/${b.id}/${b.slug}`}
                                    aria-label={b.title}
                                ></a>
                            </li>
                        ))}
                    </ul>
                </div>
            </main>
        </>
    );
}

export default Search;
