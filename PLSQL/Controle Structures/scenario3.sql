DECLARE
    CURSOR c_loans IS
        SELECT LoanID, CustomerID
        FROM Loans
        WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR r_loan IN c_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || r_loan.CustomerID || ', your loan (ID: ' || r_loan.LoanID || ') is due within 30 days.');
    END LOOP;
END;
/
