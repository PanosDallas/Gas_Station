import {useEffect, useState} from "react";

function PostContent() {


    let examplePost = {
        id: 1,
        userId: 5,
        subreditId: 1,
        title: "My first post",
        content: "This is my first post",
        createdAt: "2023-05-23",
        updatedAt: "2023-05-23"
    }


    let exampleComments = [
        {
            id: 1,
            userId: 1,
            postId: 1,
            content: "This is my first comment",
            createdAt: "2023-05-23",
            updatedAt: "2023-05-23"
        }, {
            id: 2,
            userId: 1,
            postId: 1,
            content: "This is my second comment",
            createdAt: "2023-05-23",
            updatedAt: "2023-05-23"
        }, {
            id: 2,
            userId: 1,
            postId: 1,
            content: "This is my second comment",
            createdAt: "2023-05-23",
            updatedAt: "2023-05-23"
        }, {
            id: 2,
            userId: 1,
            postId: 1,
            content: "This is my second comment",
            createdAt: "2023-05-23",
            updatedAt: "2023-05-23"
        }, {
            id: 2,
            userId: 1,
            postId: 1,
            content: "This is my second comment",
            createdAt: "2023-05-23",
            updatedAt: "2023-05-23"
        }
    ];


    let [post, setPost] = useState({});
    let [user, setUser] = useState({});
    let [comments, setComments] = useState([]);

    let id = 2;
    let jwt = localStorage.getItem("jwt")
    useEffect(() => {
        fetch(`http://localhost:8080/bootcamp-23-04/users/${id}`,
            {
                method: "GET",
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": "Bearer " + jwt
                }
            })
            .then((response) => response.json())
            .then((user) => {
                console.log(user);
                setUser(user)
            }).catch((error) => console.log(error));

        setPost(examplePost);
        setComments(exampleComments);

    }, []);




    return (
        <main>
            <h1>Post</h1>
            <h2>{post.title}</h2>

            <div className="post-content">
                <p>{post.content}</p>
                <div className="post-metadata">
                    <div>Time:</div>
                    <div>{post.updatedAt}</div>
                </div>
                <div className="post-metadata">
                    <p>Author:</p>
                    <p>{user.firstName}</p>
                </div>
            </div>
            <div className="post-comments-wrapper">
                {comments.map((comment) => (
                    <div className="comment-content">
                        <p>{comment.content}</p>
                        <div className="post-metadata">
                            <p>Time:</p>
                            <p>{comment.updatedAt}</p>
                        </div>
                        <div className="post-metadata">
                            <p>Author:</p>
                            <p>{comment.userId}</p>
                        </div>
                    </div>
                ))}


                <div className="new-comment-container">
                    <form>
                        <label htmlFor="new-comment-text">Comment Text:</label><br></br>
                        <textarea className="new-comment-input" type="text" id="new-comment-text" rows="3"
                                  name="new-comment-text">

                    </textarea><br></br>

                        <input onClick="alert('Creating new comment....')" type="image"
                               src="http://localhost:63342/bootcamp.23.04/spring-rest-app/src/main/resources/static/send.png?_ijt=2uj6oal4v77bh3geh462kdm10p&_ij_reload=RELOAD_ON_SAVE"
                               alt="Submit" width="48" height="48">
                        </input>

                    </form>
                </div>
            </div>


        </main>
    );
}

export default PostContent;