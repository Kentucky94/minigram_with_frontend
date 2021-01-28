import React from 'react';
import useStyles from "./PostCardStyles";
import Card from "@material-ui/core/Card";
import CardActionArea from "@material-ui/core/CardActionArea";
import CardMedia from "@material-ui/core/CardMedia";
import CardContent from "@material-ui/core/CardContent";
import Typography from "@material-ui/core/Typography";
import CardActions from "@material-ui/core/CardActions";
import Grid from "@material-ui/core/Grid";
import {NavLink} from "react-router-dom";

const PostCard = props => {
    const classes = useStyles();

    return (
        <Grid item xs={10} sm={6} md={5} lg={3} className={classes.root} >
            <Card className={classes.border}>
                <CardActionArea>
                    <CardMedia
                        className={classes.media}
                        image={props.image}
                    />
                    <CardContent>
                        <Typography gutterBottom variant="h5" component="h2">
                            Published by: {props.publisher}
                        </Typography>
                        <Typography variant="body2" color="textSecondary" component="p">
                            {props.description}
                        </Typography>
                    </CardContent>
                </CardActionArea>
                <CardActions>
                    <NavLink to="/posts" className={classes.link}>
                        Learn More
                    </NavLink>
                </CardActions>
            </Card>
        </Grid>
    );
};

export default PostCard;