CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_accountID IN NUMBER,
    p_amount IN NUMBER
) RETURN BOOLEAN IS
    v_balance Accounts.Balance%TYPE;
BEGIN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_accountID;
    RETURN v_balance >= p_amount;
END;
/
