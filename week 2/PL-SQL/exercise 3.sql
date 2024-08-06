--senario 1

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE savings_accounts
    SET balance = balance * 1.01;
END;

--senario 2

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (department_id IN NUMBER, bonus_percentage IN NUMBER) AS
BEGIN
    UPDATE employees
    SET salary = salary * (1 + bonus_percentage / 100)
    WHERE department_id = department_id;
END;

--senario 3

CREATE OR REPLACE PROCEDURE TransferFunds (source_account_id IN NUMBER, target_account_id IN NUMBER, amount IN NUMBER) AS
BEGIN
    DECLARE
        source_balance NUMBER;
    BEGIN
        SELECT balance INTO source_balance
        FROM accounts
        WHERE account_id = source_account_id;
        
        IF source_balance >= amount THEN
            UPDATE accounts
            SET balance = balance - amount
            WHERE account_id = source_account_id;
            
            UPDATE accounts
            SET balance = balance + amount
            WHERE account_id = target_account_id;
        END IF;
    END;
END;