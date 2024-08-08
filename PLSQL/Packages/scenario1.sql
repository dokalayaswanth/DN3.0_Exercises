DELIMITER //

CREATE PACKAGE CustomerManagement AS
    PROCEDURE AddNewCustomer(p_customerID INT, p_name VARCHAR(100), p_dob DATE, p_balance DECIMAL(10, 2));
    PROCEDURE UpdateCustomerDetails(p_customerID INT, p_name VARCHAR(100), p_dob DATE, p_balance DECIMAL(10, 2));
    FUNCTION GetCustomerBalance(p_customerID INT) RETURN DECIMAL(10, 2);
END //

CREATE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddNewCustomer(p_customerID INT, p_name VARCHAR(100), p_dob DATE, p_balance DECIMAL(10, 2)) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_customerID, p_name, p_dob, p_balance, NOW());
    END;

    PROCEDURE UpdateCustomerDetails(p_customerID INT, p_name VARCHAR(100), p_dob DATE, p_balance DECIMAL(10, 2)) IS
    BEGIN
        UPDATE Customers
        SET Name = p_name, DOB = p_dob, Balance = p_balance, LastModified = NOW()
        WHERE CustomerID = p_customerID;
    END;

    FUNCTION GetCustomerBalance(p_customerID INT) RETURN DECIMAL(10, 2) IS
        v_balance DECIMAL(10, 2);
    BEGIN
        SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_customerID;
        RETURN v_balance;
    END;

END //

DELIMITER ;
