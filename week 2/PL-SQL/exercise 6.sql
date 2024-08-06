--senario 1

DECLARE
  CURSOR GenerateMonthlyStatements IS
    SELECT customer_id, SUM(amount) AS total_amount
    FROM transactions
    WHERE EXTRACT(MONTH FROM transaction_date) = EXTRACT(MONTH FROM SYSDATE)
    GROUP BY customer_id;
BEGIN
  FOR statement IN GenerateMonthlyStatements LOOP
    DBMS_OUTPUT.PUT_LINE('Customer ' || statement.customer_id || ' Total Amount: ' || statement.total_amount);
  END LOOP;
END;

--senario 2

DECLARE
  CURSOR ApplyAnnualFee IS
    SELECT account_id
    FROM accounts;
BEGIN
  FOR account IN ApplyAnnualFee LOOP
    UPDATE accounts
    SET balance = balance - annual_fee_amount
    WHERE account_id = account.account_id;
  END LOOP;
END;

--senario 3

DECLARE
  CURSOR UpdateLoanInterestRates IS
    SELECT loan_id
    FROM loans;
BEGIN
  FOR loan_rec IN UpdateLoanInterestRates LOOP
    UPDATE loans
    SET interest_rate = new_policy_interest_rate
    WHERE loan_id = loan_rec.loan_id;
  END LOOP;
END;