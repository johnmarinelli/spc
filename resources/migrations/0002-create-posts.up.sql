CREATE SEQUENCE posts_id_seq;

--;;

CREATE TABLE posts(
  id INTEGER UNIQUE NOT NULL DEFAULT nextval('posts_id_seq'),
  title VARCHAR(100),
  body TEXT,
  created_at TIMESTAMP DEFAULT current_timestamp,
  updated_at TIMESTAMP DEFAULT current_timestamp,
  user_id INTEGER REFERENCES users(id) ON DELETE CASCADE
);

--;;

ALTER TABLE posts ADD PRIMARY KEY(id);

--;;

ALTER SEQUENCE posts_id_seq OWNED BY posts.id;
