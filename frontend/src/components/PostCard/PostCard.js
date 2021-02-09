import React, {useState} from 'react';
import {NavLink} from "react-router-dom";
import PostImageModal from "../UI/Modal/PostImageModal";
import Card from "@material-ui/core/Card";
import CardActionArea from "@material-ui/core/CardActionArea";
import CardMedia from "@material-ui/core/CardMedia";
import CardContent from "@material-ui/core/CardContent";
import Typography from "@material-ui/core/Typography";
import CardActions from "@material-ui/core/CardActions";
import Grid from "@material-ui/core/Grid";
import PostCardStyles from "./PostCardStyles";



const PostCard = props => {
    const classes = PostCardStyles();
    const [openModal, setModalOpen] = useState(false);

    const openModalHandler = () => {
        setModalOpen(true);
    };

    const closeModalHandler = () => {
        setModalOpen(false);
    };

    return (
        <Grid item xs={10} sm={6} md={5} lg={3} className={classes.root} >
            <Card className={classes.border}>
                <PostImageModal
                    isOpen={openModal}
                    closeHandler={closeModalHandler}
                    image={props.image}
                    text={props.description}
                />

                <CardActionArea onClick={openModalHandler}>
                    <CardMedia
                        className={classes.media}
                        image={props.image}
                    />
                </CardActionArea>
                <CardContent>
                    <Typography gutterBottom variant="h5" component="h2">
                        Published by: {props.publisher}
                    </Typography>
                    <Typography variant="body2" color="textSecondary" component="p">
                        {props.description}
                    </Typography>
                </CardContent>
                <CardActions>
                    <NavLink to={"/posts/" + props.id} className={classes.link}>
                        Learn More
                    </NavLink>
                </CardActions>
            </Card>
        </Grid>
    );
};

export default PostCard;