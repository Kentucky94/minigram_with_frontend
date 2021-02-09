import React, {useState} from 'react';
import {useDispatch} from "react-redux";
import {createPost} from "../../store/actions/postsActions";
import Container from "@material-ui/core/Container";
import CreatePostPageStyles from "./CreatePostPageStyles";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import SendIcon from "@material-ui/icons/Send";

const CreatePostPage = () => {
    const classes = CreatePostPageStyles();
    const dispatch = useDispatch();
    const [publishedBy, setPublishedBy] = useState('1');
    const [description, setDescription] = useState('');
    const [file, setFile] = useState(null);

    const onFileChangeHandler = e => {
        setFile(e.target.files[0])
    };

    const onSubmitHandler = e => {
        e.preventDefault();
        const imageData = new FormData();

        imageData.append("file", file);

        const postData = {
            publishedBy,
            description
        };

        dispatch(createPost(imageData, postData));
    };

    return (
        <React.Fragment>
            <Container className={classes.main}>
                <form onSubmit={onSubmitHandler} className={classes.form}>
                    <TextField
                        fullWidth
                        margin="normal"
                        type="text"
                        name="description"
                        value={description}
                        onChange={(e) => setDescription(e.target.value)}
                    />
                    <TextField
                        fullWidth
                        margin="normal"
                        type="file"
                        onChange={onFileChangeHandler}
                    />
                    <Button
                        variant="contained"
                        color="primary"
                        type="submit"
                        startIcon={<SendIcon />}
                    >
                        Send
                    </Button>
                </form>
            </Container>
        </React.Fragment>
    );
};

export default CreatePostPage;