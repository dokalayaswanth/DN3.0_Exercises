DELIMITER //

CREATE PROCEDURE UpdateLoanInterestRates()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE loan_id INT;
    DECLARE customer_id INT;
    DECLARE interest_rate DECIMAL(5, 2);
    DECLARE cur CURSOR FOR SELECT LoanID, CustomerID, InterestRate FROM Loans;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN cur;
    read_loop: LOOP
        FETCH cur INTO loan_id, customer_id, interest_rate;
        IF done THEN
            LEAVE read_loop;
        END IF;
        UPDATE Loans SET InterestRate = InterestRate * 1.05 WHERE LoanID = loan_id;  -- Assuming a 5% increase
    END LOOP;
    CLOSE cur;
    COMMIT;
END //

DELIMITER ;

CALL UpdateLoanInterestRates();
