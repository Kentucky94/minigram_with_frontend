import makeStyles from "@material-ui/core/styles/makeStyles";

const useStyles = makeStyles((theme) => ({
    container: {
        background: "#8c9eff",
        padding: "30px",
        minHeight: "90vh"
    },
    title: {
        fontSize: "20px",
        fontWeight: "bold",
        textTransform: "uppercase"
    }
}));

export default useStyles;