CREATE TABLE IF NOT EXISTS logs
(
    id           SERIAL PRIMARY KEY,
    cep          VARCHAR(10) NOT NULL,
    search_date  TIMESTAMP   NOT NULL,
    response_api JSON        NOT NULL
);
