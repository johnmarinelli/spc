CREATE TABLE likes_test (LIKE likes INCLUDING DEFAULTS INCLUDING CONSTRAINTS INCLUDING INDEXES);

--;;

ALTER TABLE likes_test ADD CONSTRAINT likes_posts_id_fkey FOREIGN KEY (post_id) REFERENCES posts_test ON DELETE CASCADE;

