import { configureStore } from "@reduxjs/toolkit";
import { blogApi } from "./services/blogs.service";
import { categoryApi } from "./services/categories.service";
import blogsReducer from "./slices/blogs.slice";

const store = configureStore({
    reducer: {
        [blogApi.reducerPath]: blogApi.reducer,
        [categoryApi.reducerPath]: categoryApi.reducer,
        blogs: blogsReducer
    },
    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware().concat(blogApi.middleware, categoryApi.middleware),
})

export default store;