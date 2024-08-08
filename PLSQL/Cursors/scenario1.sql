DELIMITER //

CREATE PROCEDURE GenerateMonthlyStatements()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE transaction_id INT;
    DECLARE account_id INT;
    DECLARE transaction_date DATE;
    DECLARE amount DECIMAL(10, 2);
    DECLARE trans_type VARCHAR(10);
    DECLARE cur CURSOR FOR SELECT TransactionID, AccountID, TransactionDate, Amount, TransactionType FROM Transactions WHERE MONTH(TransactionDate) = MONTH(CURDATE()) AND YEAR(TransactionDate) = YEAR(CURDATE());
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN cur;
    read_loop: LOOP
        FETCH cur INTO transaction_id, account_id, transaction_date, amount, trans_type;
        IF done THEN
            LEAVE read_loop;
        END IF;
        SELECT CONCAT('Statement: Transaction ID ', transaction_id, ', Account ID ', account_id, ', Date ', transaction_date, ', Amount ', amount, ', Type ', trans_type) AS statement;
    END LOOP;
    CLOSE cur;
END //

DELIMITER ;

CALL GenerateMonthlyStatements();
