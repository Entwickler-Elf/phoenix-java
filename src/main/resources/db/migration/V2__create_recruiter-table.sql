CREATE TABLE recruiter
(
    id                BIGSERIAL PRIMARY KEY,
    name              TEXT        NOT NULL,
    telephone         TEXT        NOT NULL,
    email             TEXT        NOT NULL,
    recruiter_company BIGINT REFERENCES recruiter_company (id),
    created_at        TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at        TIMESTAMPTZ NOT NULL DEFAULT NOW()
);