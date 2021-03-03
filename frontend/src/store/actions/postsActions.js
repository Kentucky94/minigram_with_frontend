import axiosOrders from "../../axiosOrders";

export const GET_POSTS_SUCCESS = "GET_POSTS_SUCCESS";

const getPostsSuccess = posts => ({type: GET_POSTS_SUCCESS, payload: {posts}});

export const getPosts = () => {
    return async dispatch => {
        try {
            const posts = await axiosOrders.get("/posts");

            dispatch(getPostsSuccess(posts.data));
        } catch (e) {
            console.log(e);
        }
    }
};

export const getPostsBySubscriber = data => {
    return async dispatch => {
        try {
            await axiosOrders.get("/posts/3");
        } catch (e) {
            console.log(e);
        }
    }
};

export const createPost = (imageData, postData) => {
    return async dispatch => {
        try {
            const imageResponse = await axiosOrders.post("/postImages/upload", imageData);
            const image = imageResponse.data;

            postData.imageId = image.id;
            const final = JSON.stringify(postData);

            await axiosOrders.post("/posts/create", final, {headers: {'Content-Type': 'application/json'}});
            // await axiosOrders.post("/posts/create", final);
        } catch (e) {
            console.log(e);
        }
    }
};