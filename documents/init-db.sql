-- Create Keycloak database and user
CREATE DATABASE keycloak;
CREATE USER keycloak WITH ENCRYPTED PASSWORD 'keycloak-db-password';
GRANT ALL PRIVILEGES ON DATABASE keycloak TO keycloak;
ALTER DATABASE keycloak OWNER TO keycloak;

-- Create Phoenix/jobhunt database and user
CREATE DATABASE jobhunt;
CREATE USER phoenix WITH ENCRYPTED PASSWORD 'phoenix-db-password';
GRANT ALL PRIVILEGES ON DATABASE jobhunt TO phoenix;
ALTER DATABASE jobhunt OWNER TO phoenix;