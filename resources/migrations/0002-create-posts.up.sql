CREATE TABLE posts(
  id SERIAL PRIMARY KEY,
  title VARCHAR(100),
  body TEXT,
  created_at TIMESTAMP DEFAULT current_timestamp,
  updated_at TIMESTAMP DEFAULT current_timestamp,
  user_id INTEGER REFERENCES users(id) ON DELETE CASCADE
);
