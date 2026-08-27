package org.example;

import java.time.LocalDate;
import java.util.UUID;

public class Student {

  private UUID studentId = UUID.randomUUID();

  private String studentName;
  private String phoneNumber;
  private String emailAddress;
  private String courseName;
  private LocalDate courseStartDate;
  private String remark;

  public Student(String studentName, String phoneNumber, String emailAddress,
      String courseName, LocalDate courseStartDate, String remark) {
    this.studentName = studentName;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
    this.courseName = courseName;
    this.courseStartDate = courseStartDate;
    this.remark = remark;
  }

  public String getStudentName() {
    return this.studentName;
  }

  @Override
  public String toString() {
    return "受講生ID：" + this.studentId
        + " / 氏名：" + this.studentName
        + " / 電話番号：" + this.phoneNumber
        + " / メールアドレス：" + this.emailAddress
        + " / 受講コース：" + this.courseName
        + " / コース開始日：" + this.courseStartDate
        + " / 備考：" + this.remark;
  }
}
