import {makeStyles} from "@material-ui/styles";

const useStyles = makeStyles({
    root: {
        maxWidth: "100%",
    },
    border: {
        border: "2px solid black"
    },
    media: {
        height: 140,
    },
    link: {
        textDecoration: "none",
        color: "white",
        background: "#2196f3",
        borderRadius: "3px",
        padding: "10px 15px",
        display: "block",
        margin: "0 auto"
    }
});

export default useStyles;