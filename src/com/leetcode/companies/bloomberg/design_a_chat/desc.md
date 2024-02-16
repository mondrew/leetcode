# Chat rooms context for a sender

There are multiple chat rooms.

#### Chat Room 42
```
8:30:29 Helen Atencio: Good morning, all.
9:31:02 Lois Price: Did you read the news?
9:35:23 Helen Atencio: I guess I missed it
9:35:58 Lois Price: WSJ front page
...
```

#### Chat Room 13
```
9:31:30 Frances Cavalier: Selling 1500 RTT @ $342.2, any takers?
9:31:42 Helen Atencio: $338?
9:32:50 Helen Atencio: actually, $340.5
9:32:56 Frances Cavalier: done
9:36:43 Gerald Haywood: that was fast
...
```

IMPost class:
```
class IMPost:
timestamp: int
chatroom_id: str
sender_id: str
message_text: str
```

Input data example:
```
EXAMPLE_IM_STREAM = [
    IMPost(83039, '42', 'Helen Atencio', 'Good morning, all.'),
    IMPost(93102, '42', 'Lois Price', 'Did you read the news?'),
    IMPost(93130, '13', 'Frances Cavalier', 'Selling 1500 RTT @ $342.2, any takers?'),
    IMPost(93142, '13', 'Helen Atencio', '$338?'),
    IMPost(93250, '13', 'Helen Atencio', 'actually, $340.5'),
    IMPost(93256, '13', 'Frances Cavalier', 'done'),
    IMPost(93523, '42', 'Helen Atencio', 'I guess I missed it'),
    IMPost(93558, '42', 'Lois Price', 'WSJ front page'),
    IMPost(93643, '13', 'Gerald Haywood', 'that was fast'),
    ...
]
```

Call example:
```
get_conversational_context(EXAMPLE_IM_STREAM, "Helen Atencio", 1)
```

Output example:
```
[
    [
        IMPost(93130, '13', 'Frances Cavalier', 'Selling 1500 RTT @ $342.2, any takers?'),
        IMPost(93142, '13', 'Helen Atencio', '$338?'),
        IMPost(93250, '13', 'Helen Atencio', 'actually, $340.5'),
    ],
    [
        IMPost(93102, '42', 'Lois Price', 'Did you read the news?'),
        IMPost(93523, '42', 'Helen Atencio', 'I guess I missed it'),
        IMPost(93558, '42', 'Lois Price', 'WSJ front page'),
    ],
]
```

Create a function:
```
def get_conversational_context(im_stream, target_sender_id, window_size)
```
Where:
- im_stream: A stream (generator) that produces IMPosts. Calling next(im_stream) will yield a new post.
- target_sender_id: a string, the sender_id of the user we want to get a context for
- window_size: The number of posts before and after the target post that should be included
in the context.

Returns: An iterable (anything we can iterate over) containing the posts from the first conversational context found in im_stream.

A context consists of a "target post" sent by target_sender_id, plus the window_size posts immediately before and after the anchor post that were made in the same chatroom.