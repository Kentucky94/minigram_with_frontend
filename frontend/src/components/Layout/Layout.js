import React from 'react';
import Appbar from "../Appbar/Appbar";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";

import PostPage from "../../containers/PostPage/PostPage";
import CreatePostPage from "../../containers/CreatePostPage/CreatePostPage";

const Layout = () => {
    return (
        <div style={{background: "black"}}>
            <Appbar />

            <Router>
                <Switch>
                    <Route path="/" exact component={PostPage} />
                    <Route path="/posts/create" exact component={CreatePostPage} />
                </Switch>
            </Router>
        </div>
    );
};

export default Layout;