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

    for (Student student : students) {
      System.out.println(student.toString());
    }
  }
}
