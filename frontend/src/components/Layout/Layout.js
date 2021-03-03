import React from 'react';
import Appbar from "../Appbar/Appbar";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";

import PostPage from "../../containers/PostPage/PostPage";
import CreatePostPage from "../../containers/CreatePostPage/CreatePostPage";
import LoginPage from "../../containers/LoginPage/LoginPage";

const Layout = () => {
    return (
        <div>
            <Router>
                <Appbar />

                <Switch>
                    <Route path="/" exact component={PostPage} />
                    <Route path="/posts/create" exact component={CreatePostPage} />
                    <Route path="/login" exact component={LoginPage} />
                </Switch>
            </Router>
        </div>
    );
};

export default Layout;