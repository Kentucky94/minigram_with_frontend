import React from 'react';
import Appbar from "../Appbar/Appbar";
import {Route, Switch} from "react-router-dom";

import PostPage from "../../containers/PostPage/PostPage";
import CreatePostPage from "../../containers/CreatePostPage/CreatePostPage";
import LoginPage from "../../containers/LoginPage/LoginPage";
import RegisterPage from "../../containers/RegisterPage/RegisterPage";

const Layout = () => {
    return (
        <React.Fragment>
            <Appbar/>

            <Switch>
                <Route path="/" exact component={PostPage}/>
                <Route path="/posts/create" exact component={CreatePostPage}/>
                <Route path="/login" exact component={LoginPage}/>
                <Route path="/register" exact component={RegisterPage}/>
            </Switch>
        </React.Fragment>
    );
};

export default Layout;