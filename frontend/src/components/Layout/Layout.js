import React from 'react';
import Appbar from "../Appbar/Appbar";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";

import PostPage from "../../containers/PostPage/PostPage";

const Layout = () => {
    return (
        <div style={{background: "black"}}>
            <Appbar />

            <Router>
                <Switch>
                    <Route path="/" component={PostPage} />
                </Switch>
            </Router>
        </div>
    );
};

export default Layout;