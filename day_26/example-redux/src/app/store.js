import { combineReducers, createStore } from "redux";
import counterReducer from "./reducers/counterReducer";

// Gộp các reducer lại với nhau
const rootReducer = combineReducers({
    counter: counterReducer
})

const store = createStore(rootReducer)

export default store;