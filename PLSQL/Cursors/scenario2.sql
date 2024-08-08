DELIMITER //

CREATE PROCEDURE ApplyAnnualFee()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE account_id INT;
    DECLARE balance DECIMAL(10, 2);
    DECLARE cur CURSOR FOR SELECT AccountID, Balance FROM Accounts;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN cur;
    read_loop: LOOP
        FETCH cur INTO account_id, balance;
        IF done THEN
            LEAVE read_loop;
        END IF;
        UPDATE Accounts SET Balance = Balance - 50 WHERE AccountID = account_id;  -- Assuming annual fee is 50
    END LOOP;
    CLOSE cur;
    COMMIT;
END //

DELIMITER ;

CALL ApplyAnnualFee();
