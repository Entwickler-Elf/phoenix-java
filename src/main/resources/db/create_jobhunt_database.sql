-- Create the new user
CREATE USER jobhunt_user WITH PASSWORD 'jobhunt_password';

-- Create the database
CREATE DATABASE jobhunt;

-- Grant all privileges on the database to your new user
GRANT ALL PRIVILEGES ON DATABASE jobhunt TO jobhunt_user;

-- (Optional but recommended for modern Postgres)
-- Ensure the user can create tables in the 'public' schema
\c jobhunt
GRANT ALL ON SCHEMA public TO jobhunt_user;
ALTER SCHEMA public OWNER TO your_db_user;