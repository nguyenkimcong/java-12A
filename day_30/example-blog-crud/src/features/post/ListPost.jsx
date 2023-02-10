import React from "react";
import { useGetPostsQuery } from "../../app/services/posts.api";
import { postsSelector } from "../../app/slices/posts.slice";

function ListPost() {
    const { isLoading, error, isError } = useGetPostsQuery();
    // const posts = useSelector(selectAllPosts());
    // console.log(useSelector(selectAllPosts()));
    const posts = postsSelector.selectAll();
    console.log(posts);

    // console.log(posts);

    if (isLoading) {
        return <h2>Loading ...</h2>;
    }

    if (isError) {
        return <h2>Error : {error.message}</h2>;
    }
    return (
        <div>
            <h2>List post</h2>
            {/* <ul>
                {posts.length > 0 && posts.map((p) => (
                    <li key={p.id}>{p.title}</li>
                ))}
            </ul> */}
        </div>
    );
}

export default ListPost;
