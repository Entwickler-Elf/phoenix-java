-- V1__create_recruiter-company-table.sql
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



