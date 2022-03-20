//package com.bugtrackerv2.server.domain;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//class UserTest {
//    @Test
//    void shouldCheckThatUsersWithSameEmailAreEqual() {
//        User user1 = new User("Billy", "Bob", "b@gmail.com", "password");
//        User user2 = new User("Anthony", "Viera", "b@gmail.com", "password");
//        assertThat(user1).isEqualTo(user2);
//    }
//
//    @Test
//    void shouldCheckThatUsersWithSameEmailAreDuplicatesInSet() {
//        Set<User> set = new HashSet<>();
//        User user1 = new User("Anthony", "Viera", "a@gmail.com", "password");
//        User user2 = new User("John", "Doe", "a@gmail.com", "password");
//        set.add(user1);
//        set.add(user2);
//        assertThat(set.size()).isEqualTo(1);
//    }
//}