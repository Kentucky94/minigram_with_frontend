import React, {useEffect} from 'react';
import {Container} from "@material-ui/core";
import useStyles from "./PostPageStyles";
import {useDispatch, useSelector} from "react-redux";
import {getPosts} from "../../store/actions/postsActions";
import Typography from "@material-ui/core/Typography";
import PostCard from "../../components/PostCard/PostCard";
import Grid from "@material-ui/core/Grid";
import config from "../../config";
import {NavLink} from "react-router-dom";

const PostPage = () => {
    const classes = useStyles();
    const dispatch = useDispatch();
    const postsData = useSelector(state => state.posts.posts);

    useEffect(() => {
        dispatch(getPosts())
    }, [dispatch]);

    const posts = postsData.map(p => {
        return (
            <PostCard
                key={p.id}
                publisher={p.publishedBy}
                description={p.description}
                image={config.host + "/" + p.image}
            />
        )
    });

    return (
        <Container component="div" className={classes.container}>
            <Grid component="div" container spacing={2}>
                <Grid component="div" item xs={12}>
                    <Typography component="h2" className={classes.title}>Post page</Typography>
                </Grid>
                <Grid component="div" item xs={12}>
                    <NavLink to="/posts/create">Add</NavLink>
                </Grid>

                <Grid container justify="space-around" spacing={4}>
                    {posts}
                </Grid>
            </Grid>
        </Container>
    );
};

export default PostPage;