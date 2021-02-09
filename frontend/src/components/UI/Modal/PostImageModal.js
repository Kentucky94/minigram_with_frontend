import React from 'react';
import Modal from "@material-ui/core/Modal";
import Fade from "@material-ui/core/Fade";
import Typography from "@material-ui/core/Typography";
import PostImageModalStyles from "./PostImageModalStyles";



const PostImageModal = props => {
    const classes = PostImageModalStyles();

    return (
        <Modal className={classes.modal} open={props.isOpen} onClose={props.closeHandler}>
            <Fade in={props.isOpen} className={classes.paper}>
                <div>
                    <img src={props.image} className={classes.image} alt=""/>
                    <Typography variant='inherit'>
                        {props.text}
                    </Typography>
                </div>
            </Fade>
        </Modal>
    );
};

export default PostImageModal;