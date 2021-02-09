import {makeStyles} from "@material-ui/styles";

const PostImageModalStyles = makeStyles({
    image: {
        maxWidth: "100%",
        borderRadius: '10px',
        marginBottom: '20px',
    },
    modal: {
        position: 'relative',
        overflowY: 'scroll',
    },
    paper: {
        background: 'purple',
        position: 'absolute',
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        width: '70%',
        maxHeight: '70vh',
        padding: '20px',
        overflowY: 'scroll'
    }
});

export default PostImageModalStyles;