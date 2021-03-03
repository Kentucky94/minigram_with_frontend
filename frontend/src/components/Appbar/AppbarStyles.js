import {makeStyles} from "@material-ui/core";

const useStyles = makeStyles((theme) => ({
    main: {
        background: "lightgrey",
        padding: "10px"
    },
    root: {
        flexGrow: 1,
    },
    menuButton: {
        marginRight: theme.spacing(2),
    },
    title: {
        flexGrow: 1,
    },
}));

export default useStyles;