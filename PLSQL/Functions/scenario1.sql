CREATE OR REPLACE FUNCTION CalculateAge (
    p_dob IN DATE
) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    v_age := TRUNC((SYSDATE - p_dob) / 365.25);
    RETURN v_age;
END;
/
