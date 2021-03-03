import React from 'react';

import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import IconButton from "@material-ui/core/IconButton";
import Typography from "@material-ui/core/Typography";
import Button from "@material-ui/core/Button";
import MenuIcon from '@material-ui/icons/Menu';
import useStyles from "./AppbarStyles";
import {Container} from "@material-ui/core";
import {NavLink} from "react-router-dom";

const Appbar = () => {
    const classes = useStyles();

    return (
        <Container>
            <AppBar position="static" className={classes.main}>
                <Toolbar>
                    <IconButton edge="start"  color="inherit" aria-label="menu">
                        <MenuIcon />
                    </IconButton>
                    <Typography variant="h6" className={classes.title}>
                        <NavLink to={"/"}>News</NavLink>
                    </Typography>
                    <Button color="inherit">Login</Button>
                </Toolbar>
            </AppBar>
        </Container>
    );
};

export default Appbar;