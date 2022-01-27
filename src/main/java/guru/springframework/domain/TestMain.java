package guru.springframework.domain;

import java.util.Set;

public class TestMain {
  public static void main(String[] args) {
    Set<String> stringSet = new java.util.HashSet<>(Set.of("a", "b"));
    stringSet.add("c");
    System.out.println(stringSet);
  }
}
