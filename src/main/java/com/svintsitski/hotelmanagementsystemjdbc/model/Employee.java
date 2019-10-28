package com.svintsitski.hotelmanagementsystemjdbc.model;

import java.util.Objects;

public class Employee {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String gender;
    private String phone;
    private String address;
    private String passportId;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(patronymic, employee.patronymic) &&
                Objects.equals(gender, employee.gender) &&
                Objects.equals(phone, employee.phone) &&
                Objects.equals(address, employee.address) &&
                Objects.equals(passportId, employee.passportId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, patronymic, gender, phone, address, passportId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", passportId='" + passportId + '\'' +
                '}';
    }

    public Employee(Integer employeeId, String firstName, String lastName, String patronymic, String gender, String phone, String address, String passportId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.passportId = passportId;
    }

    public Employee() {
    }
}
