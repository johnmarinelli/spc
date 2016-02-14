CREATE SEQUENCE users_id_seq;

--;;

CREATE TABLE users(
  id INTEGER UNIQUE NOT NULL DEFAULT nextval('users_id_seq'),
  username VARCHAR(20), 
  salt VARCHAR(20), 
  password VARCHAR(20), 
  email VARCHAR(200),
  last_login TIMESTAMP DEFAULT current_timestamp,
  created_at TIMESTAMP DEFAULT current_timestamp,
  updated_at TIMESTAMP DEFAULT current_timestamp
); 

--;;

ALTER TABLE users ADD PRIMARY KEY(id);

--;;

ALTER SEQUENCE users_id_seq OWNED BY users.id;

