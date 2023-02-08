import { configureStore } from "@reduxjs/toolkit";
import { blogApi } from "./services/blogs.service";
import blogsReducer from "./slices/blogs.slice";

const store = configureStore({
    reducer: {
        [blogApi.reducerPath]: blogApi.reducer,
        blogs: blogsReducer
    },
    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware().concat(blogApi.middleware),
})

export default store;