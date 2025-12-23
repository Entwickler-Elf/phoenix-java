-- V1__init.sql
CREATE TABLE recruiter_company
(
    id         BIGSERIAL PRIMARY KEY,
    name       TEXT        NOT NULL,
    telephone  TEXT        NOT NULL,
    email      TEXT        NOT NULL,
    company    TEXT        NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_recruiter_company_name ON recruiter_company(name);

CREATE TABLE recruiters
(
    id                BIGSERIAL PRIMARY KEY,
    name              TEXT        NOT NULL,
    telephone         TEXT        NOT NULL,
    email             TEXT        NOT NULL,
    recruiter_company BIGINT REFERENCES recruiter_company (id),
    created_at        TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at        TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

