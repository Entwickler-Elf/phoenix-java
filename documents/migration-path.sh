# 1. Backup existing jobhunt database
pg_dump -U your-user jobhunt > jobhunt-backup.sql

# 2. Start containerized PostgreSQL
docker-compose up -d postgres

# 3. Wait for PostgreSQL to be ready
docker-compose logs -f postgres

# 4. Restore data
docker exec -i postgres-zeus psql -U postgres jobhunt < jobhunt-backup.sql

# 5. Verify
docker exec -it postgres-zeus psql -U postgres -d jobhunt -c "\dt"