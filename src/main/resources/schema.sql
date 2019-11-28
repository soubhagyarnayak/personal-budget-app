CREATE TABLE IF NOT EXISTS ExpenseEntry (
  Id UUID NOT NULL,
  Description NVARCHAR(1000) NOT NULL,
  Category NVARCHAR(250) NOT NULL,
  Amount DOUBLE NOT NULL,
  CreateTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UpdateTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);