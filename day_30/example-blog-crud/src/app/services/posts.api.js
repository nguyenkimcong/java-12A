import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";

const postApi = createApi({
    reducerPath: "postApi",
    baseQuery: fetchBaseQuery({
        baseUrl: "https://jsonplaceholder.typicode.com"
    }),
    endpoints: (builder) => ({
        getPosts: builder.query({
            query: () => "posts"
        })
    })
})

export const { useGetPostsQuery } = postApi;
export default postApi;