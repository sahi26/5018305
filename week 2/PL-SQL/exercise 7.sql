--senario 1

CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE addNewCustomer(customer_id IN NUMBER, customer_name IN VARCHAR2, customer_email IN VARCHAR2);
    PROCEDURE updateCustomerDetails(customer_id IN NUMBER, new_customer_name IN VARCHAR2, new_customer_email IN VARCHAR2);
    FUNCTION getCustomerBalance(customer_id IN NUMBER) RETURN NUMBER;
END CustomerManagement;

--senario 2

CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE hireNewEmployee(employee_id IN NUMBER, employee_name IN VARCHAR2, employee_salary IN NUMBER);
    PROCEDURE updateEmployeeDetails(employee_id IN NUMBER, new_employee_name IN VARCHAR2, new_employee_salary IN NUMBER);
    FUNCTION calculateAnnualSalary(employee_id IN NUMBER) RETURN NUMBER;
END EmployeeManagement;

--senario 3

CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE openNewAccount(account_id IN NUMBER, customer_id IN NUMBER, initial_balance IN NUMBER);
    PROCEDURE closeAccount(account_id IN NUMBER);
    FUNCTION getTotalBalance(customer_id IN NUMBER) RETURN NUMBER;
END AccountOperations;