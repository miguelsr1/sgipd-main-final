--liquibase formatted sql

--changeset xtecuan:0.4 dbms:mssql
CREATE VIEW dbo.Plazas2021_from_prod AS
SELECT p.* FROM SOL_MINED_SV_PROD.dbo.Plaza2021 p;
--rollback drop view Plazas2021_from_prod;