package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Student> students = new ArrayList<>();

// インスタンスが作られた時点で、studentIdは作られているので、コンストラクタの引数で渡す必要はない
    students.add(new Student(
        "山田太郎",
        "090-1234-5678",
        "yamada@example.com",
        "Javaコース",
        LocalDate.of(2026, 8, 1),
        "平日は18時以降に連絡希望"));

    students.add(new Student(
        "佐藤花子",
        "080-9876-5432",
        "sato@example.com",
        "Webコース",
        LocalDate.of(2026, 8, 15),
        "メールでの連絡希望"
    ));

// System.out.println(students.toString()); という書き方もできるが、受講生一覧表示ならfor文の方が見やすく、自然。
// println() にオブジェクトを渡すと、内部的にそのオブジェクトの toString() が使われる。
// System.out.println(student.toString());のtoString()は省略できるが、今は勉強のため書いておく。
    System.out.println("-----すべての受講生の情報を表示します-----");
    for (Student student : students) {
      System.out.println(student.toString());
    }

    String searchStudentName = "山田太郎";
    searchStudentByName(students, searchStudentName);

    updateCourseName(students, searchStudentName);

    System.out.println("-----すべての受講生の情報を表示します-----");
    for (Student student : students) {
      System.out.println(student.toString());
    }

    deleteStudent(students, searchStudentName);

    System.out.println("-----すべての受講生の情報を表示します-----");
    for (Student student : students) {
      System.out.println(student.toString());
    }
  }

  // 受講生の名前で検索するメソッド
  // 特定のインスタンスの情報に依存しない処理のため、staticメソッド
  public static void searchStudentByName(List<Student> students, String searchStudentName) {

    boolean foundStudent = false;

    for (Student student : students) {
      if (student.getStudentName().equals(searchStudentName)) {
        foundStudent = true;
        System.out.println("-----" +
            searchStudentName + "さんが見つかりました。情報を表示します-----");
        System.out.println(student.toString());
      }
    }

// !foundStudentは、foundStudent == falseと同じ意味
    if (!foundStudent) {
      System.out.println("-----" + searchStudentName + "さんは、見つかりませんでした-----");
    }
  }

  // 受講生の受講コースの更新処理
  // ここでは、受講コース名をAWSコースに変更という固定で作ってみる
  public static void updateCourseName(List<Student> students, String searchStudentName) {

    boolean foundStudent = false;

    for (Student student : students) {
      if (student.getStudentName().equals(searchStudentName)) {
        foundStudent = true;

        String beforeChangedCourseName = student.getCourseName();

        student.setCourseName("AWSコース");

        System.out.println("-----" + searchStudentName + "さんの受講コースを変更しました。変更前："
            + beforeChangedCourseName
            + " → 変更後：AWSコース-----");
      }
    }
    if (!foundStudent) {
      System.out.println(
          "-----更新できませんでした。" + searchStudentName + "さんは、見つかりませんでした-----");
    }
  }

  // 受講生の情報の削除処理
  public static void deleteStudent(List<Student> students, String searchStudentName) {
    Student studentToDelete = null;

    for (Student student : students) {
      if (student.getStudentName().equals(searchStudentName)) {
        studentToDelete = student;
      }
    }
    if (studentToDelete != null) {
      students.remove(studentToDelete);

      System.out.println(
          "-----" + searchStudentName + "さんを削除しました-----\n削除した受講生 → "
              + studentToDelete.toString());
    } else {
      System.out.println("-----" + searchStudentName + "さんは、見つかりませんでした-----");
    }
  }
}
