import axiosOrders from "../../axiosOrders";

export const GET_POSTS_SUCCESS = "GET_POSTS_SUCCESS";

const getPostsSuccess = posts => ({type: GET_POSTS_SUCCESS, payload: {posts}});

export const getPosts = () => {
    return async dispatch => {
        //const posts = [{title: "post1"}, {title: "post2"}];
        const posts = await axiosOrders.get("/posts");

        dispatch(getPostsSuccess(posts.data));
    }
};