CREATE SEQUENCE likes_id_seq;

--;;


CREATE TABLE likes(
  id INTEGER NOT NULL DEFAULT nextval('likes_id_seq'),
  post_id INTEGER REFERENCES posts(id) ON DELETE CASCADE
);

--;;

ALTER TABLE likes ADD PRIMARY KEY(id);

--;;

ALTER SEQUENCE likes_id_seq OWNED BY likes.id;
