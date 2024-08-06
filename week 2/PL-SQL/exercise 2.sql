--senario 1

CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    from_account_id IN NUMBER,
    to_account_id IN NUMBER,
    amount IN NUMBER
) AS
BEGIN
    SAVEPOINT start_tran;
    
    UPDATE accounts
    SET balance = balance - amount
    WHERE account_id = from_account_id;
    
    UPDATE accounts
    SET balance = balance + amount
    WHERE account_id = to_account_id;
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK TO start_tran;
        DBMS_OUTPUT.PUT_LINE('Error during fund transfer: ' || SQLERRM);
END;
/

-- senario 2

CREATE OR REPLACE PROCEDURE UpdateSalary (
    employee_id IN NUMBER,
    percentage_increase IN NUMBER
) AS
BEGIN
    UPDATE employees
    SET salary = salary * (1 + percentage_increase/100)
    WHERE employee_id = employee_id;
    
    IF SQL%NOTFOUND THEN
        DBMS_OUTPUT.PUT_LINE('Employee with ID ' || employee_id || ' not found.');
    END IF;
END;
/

--senario 3

CREATE OR REPLACE PROCEDURE AddNewCustomer (
    customer_id IN NUMBER,
    customer_name IN VARCHAR2,
    customer_address IN VARCHAR2
) AS
BEGIN
    INSERT INTO customers (customer_id, name, address)
    VALUES (customer_id, customer_name, customer_address);
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Customer with ID ' || customer_id || ' already exists.');
END;
/



