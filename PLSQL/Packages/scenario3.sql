DELIMITER //

CREATE PACKAGE AccountOperations AS
    PROCEDURE OpenNewAccount(p_accountID INT, p_customerID INT, p_accountType VARCHAR(20), p_balance DECIMAL(10, 2));
    PROCEDURE CloseAccount(p_accountID INT);
    FUNCTION GetTotalBalance(p_customerID INT) RETURN DECIMAL(10, 2);
END //

CREATE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenNewAccount(p_accountID INT, p_customerID INT, p_accountType VARCHAR(20), p_balance DECIMAL(10, 2)) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_accountID, p_customerID, p_accountType, p_balance, NOW());
    END;

    PROCEDURE CloseAccount(p_accountID INT) IS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_accountID;
    END;

    FUNCTION GetTotalBalance(p_customerID INT) RETURN DECIMAL(10, 2) IS
        v_total_balance DECIMAL(10, 2);
    BEGIN
        SELECT SUM(Balance) INTO v_total_balance FROM Accounts WHERE CustomerID = p_customerID;
        RETURN v_total_balance;
    END;

END //

DELIMITER ;
