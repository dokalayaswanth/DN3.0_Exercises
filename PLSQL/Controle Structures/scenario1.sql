DECLARE
    CURSOR c_customers IS SELECT CustomerID, DOB FROM Customers;
    v_customerID Customers.CustomerID%TYPE;
    v_DOB Customers.DOB%TYPE;
    v_age NUMBER;
BEGIN
    FOR r_customer IN c_customers LOOP
        v_age := TRUNC((SYSDATE - r_customer.DOB) / 365.25);
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = r_customer.CustomerID;
        END IF;
    END LOOP;
END;
/

