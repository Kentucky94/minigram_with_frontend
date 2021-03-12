import React from 'react';

import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import IconButton from "@material-ui/core/IconButton";
import Typography from "@material-ui/core/Typography";
import MenuIcon from '@material-ui/icons/Menu';
import useStyles from "./AppbarStyles";
import {Container} from "@material-ui/core";
import {NavLink} from "react-router-dom";
import {useSelector} from "react-redux";

const Appbar = () => {
    const classes = useStyles();
    const user = useSelector(state => state.users.user);

    const greetings = !!user ? (`Hello, ${user.username}`) : null;

    return (
        <Container>
            <AppBar position="static" className={classes.main}>
                <Toolbar>
                    <IconButton edge="start"  color="inherit" aria-label="menu">
                        <MenuIcon />
                    </IconButton>
                    <Typography variant="h6" className={classes.title}>
                        <NavLink to="/">News</NavLink>
                    </Typography>

                    {greetings}
                    <NavLink className={classes.link} to="/login" color="inherit">Login</NavLink>
                    <NavLink className={classes.link} to="/register" color="inherit">Register</NavLink>
                </Toolbar>
            </AppBar>
        </Container>
    );
};

export default Appbar;