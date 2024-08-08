CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loanAmount IN NUMBER,
    p_interestRate IN NUMBER,
    p_loanDuration IN NUMBER
) RETURN NUMBER IS
    v_monthlyRate NUMBER;
    v_totalMonths NUMBER;
    v_monthlyInstallment NUMBER;
BEGIN
    v_monthlyRate := p_interestRate / 12 / 100;
    v_totalMonths := p_loanDuration * 12;
    v_monthlyInstallment := p_loanAmount * v_monthlyRate / (1 - POWER(1 + v_monthlyRate, -v_totalMonths));
    RETURN v_monthlyInstallment;
END;
/
