import React, {useState} from 'react';
import useStyles from "../../components/Form/FormStyles";
import Container from "@material-ui/core/Container";
import CssBaseline from "@material-ui/core/CssBaseline/CssBaseline";
import Avatar from "@material-ui/core/Avatar";
import LockOutlinedIcon from "@material-ui/core/SvgIcon/SvgIcon";
import Typography from "@material-ui/core/Typography";
import TextField from "@material-ui/core/TextField/TextField";
import Button from "@material-ui/core/Button";
import {useDispatch} from "react-redux";
import {registerUser} from "../../store/actions/usersActions";

const RegisterPage = () => {
    const classes = useStyles();
    const dispatch = useDispatch();

    const [state, setState] = useState({
        username: '',
        password: '',
        email: ''
    });

    const onSubmitHandler = e => {
        e.preventDefault();

        dispatch(registerUser({username: state.username, password: state.password, email: state.email}));
    };

    const onFieldChange = e => {
        const {name, value} = e.target;

        setState({...state, [name]: value})
    };

    return (
        <Container className={classes.main} component="main" maxWidth="xs">
            <CssBaseline />
            <div className={classes.paper}>
                <Avatar className={classes.avatar}>
                    <LockOutlinedIcon />
                </Avatar>
                <Typography component="h1" variant="h5">
                    Sign in
                </Typography>
                <form className={classes.form} noValidate onSubmit={onSubmitHandler}>
                    <TextField
                        onChange={onFieldChange}
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        id="username"
                        label="Username"
                        name="username"
                        autoFocus
                    />
                    <TextField
                        onChange={onFieldChange}
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        name="password"
                        label="Password"
                        type="password"
                        id="password"
                        autoComplete="current-password"
                    />

                    <TextField
                        onChange={onFieldChange}
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        name="email"
                        label="Email"
                        type="text"
                        id="email"
                    />

                    <Button
                        type="submit"
                        fullWidth
                        variant="contained"
                        color="primary"
                        className={classes.submit}
                    >
                        Sign Up
                    </Button>

                </form>
            </div>
        </Container>
    );
};

export default RegisterPage;