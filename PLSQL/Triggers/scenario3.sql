CREATE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
BEGIN
    IF NEW.TransactionType = 'Withdrawal' THEN
        DECLARE account_balance DECIMAL(10, 2);
        SELECT Balance INTO account_balance FROM Accounts WHERE AccountID = NEW.AccountID;
        IF NEW.Amount > account_balance THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Insufficient funds for withdrawal.';
        END IF;
    ELSEIF NEW.TransactionType = 'Deposit' THEN
        IF NEW.Amount <= 0 THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Deposit amount must be positive.';
        END IF;
    END IF;
END;
