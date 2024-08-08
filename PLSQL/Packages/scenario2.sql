DELIMITER //

CREATE PACKAGE EmployeeManagement AS
    PROCEDURE HireNewEmployee(p_employeeID INT, p_name VARCHAR(100), p_position VARCHAR(50), p_salary DECIMAL(10, 2), p_department VARCHAR(50), p_hireDate DATE);
    PROCEDURE UpdateEmployeeDetails(p_employeeID INT, p_name VARCHAR(100), p_position VARCHAR(50), p_salary DECIMAL(10, 2), p_department VARCHAR(50));
    FUNCTION CalculateAnnualSalary(p_employeeID INT) RETURN DECIMAL(10, 2);
END //

CREATE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireNewEmployee(p_employeeID INT, p_name VARCHAR(100), p_position VARCHAR(50), p_salary DECIMAL(10, 2), p_department VARCHAR(50), p_hireDate DATE) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_employeeID, p_name, p_position, p_salary, p_department, p_hireDate);
    END;

    PROCEDURE UpdateEmployeeDetails(p_employeeID INT, p_name VARCHAR(100), p_position VARCHAR(50), p_salary DECIMAL(10, 2), p_department VARCHAR(50)) IS
    BEGIN
        UPDATE Employees
        SET Name = p_name, Position = p_position, Salary = p_salary, Department = p_department
        WHERE EmployeeID = p_employeeID;
    END;

    FUNCTION CalculateAnnualSalary(p_employeeID INT) RETURN DECIMAL(10, 2) IS
        v_salary DECIMAL(10, 2);
    BEGIN
        SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_employeeID;
        RETURN v_salary * 12;
    END;

END //

DELIMITER ;
