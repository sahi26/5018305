-- senario 1
DECLARE
    v_discount_rate NUMBER := 0.01;
BEGIN
    FOR customer_rec IN (SELECT customer_id, age, loan_interest_rate FROM customers)
    LOOP
        IF customer_rec.age > 60 THEN
            UPDATE loans
            SET loan_interest_rate = loan_interest_rate - (loan_interest_rate * v_discount_rate)
            WHERE customer_id = customer_rec.customer_id;
        END IF;
    END LOOP;
END;
/
-- senario 2
DECLARE
BEGIN
    FOR customer_rec IN (SELECT customer_id, balance FROM customers)
    LOOP
        IF customer_rec.balance > 10000 THEN
            UPDATE customers
            SET IsVIP = TRUE
            WHERE customer_id = customer_rec.customer_id;
        END IF;
    END LOOP;
END;
/
-- senario 3
DECLARE
BEGIN
    FOR loan_rec IN (SELECT customer_id, loan_due_date FROM loans WHERE loan_due_date <= SYSDATE + 30)
    LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Your loan is due within the next 30 days. Please make the payment.');
    END LOOP;
END;
/