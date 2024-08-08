CREATE OR REPLACE PROCEDURE TransferFunds (
    p_fromAccountID IN NUMBER,
    p_toAccountID IN NUMBER,
    p_amount IN NUMBER
) IS
    v_fromBalance Accounts.Balance%TYPE;
BEGIN
    SELECT Balance INTO v_fromBalance FROM Accounts WHERE AccountID = p_fromAccountID FOR UPDATE;
    IF v_fromBalance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds.');
    END IF;

    UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_fromAccountID;
    UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_toAccountID;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
