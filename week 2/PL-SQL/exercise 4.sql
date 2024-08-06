
-- senario 1

CREATE OR REPLACE FUNCTION CalculateAge (dob IN DATE)
RETURN NUMBER IS
BEGIN
    RETURN FLOOR(MONTHS_BETWEEN(SYSDATE, dob) / 12);
END;

-- senario 2

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (loan_amount IN NUMBER, interest_rate IN NUMBER, loan_duration IN NUMBER)
RETURN NUMBER IS
    monthly_installment NUMBER;
BEGIN
    monthly_installment := (loan_amount * interest_rate / 1200) / (1 - (1 + interest_rate / 1200)**(-loan_duration * 12));
    RETURN monthly_installment;
END;

-- senario 3

CREATE OR REPLACE FUNCTION HasSufficientBalance (account_id IN NUMBER, amount IN NUMBER)
RETURN BOOLEAN IS
    current_balance NUMBER;
BEGIN
    SELECT balance INTO current_balance FROM accounts WHERE account_id = account_id;
    IF current_balance >= amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
END;
