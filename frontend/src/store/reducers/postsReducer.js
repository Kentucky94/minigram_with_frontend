import {GET_POSTS_SUCCESS} from "../actions/postsActions";

const initialState = {
    posts: []
};

const postsReducer =  (state = initialState, action) => {
    switch (action.type) {
        case GET_POSTS_SUCCESS:
            const {posts} = action.payload;

            return {...state, posts};
        default:
            return state;
    }
};

export default postsReducer;