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

    String searchStudentName = "佐藤一郎";
    searchStudentByName(students, searchStudentName);
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
}
