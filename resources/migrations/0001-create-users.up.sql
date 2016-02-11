CREATE TABLE users(
  id INTEGER UNIQUE,
  username VARCHAR(20), 
  salt VARCHAR(20), 
  password VARCHAR(20), 
  email VARCHAR(200),
  last_login TIMESTAMP DEFAULT current_timestamp,
  created_at TIMESTAMP DEFAULT current_timestamp,
  updated_at TIMESTAMP DEFAULT current_timestamp,
  CONSTRAINT users_id_pkey PRIMARY KEY (id)
); 

