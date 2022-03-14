package com.bugtrackerv2.server.domain;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AppUserTest {
    @Test
    void shouldCheckThatUsersWithSameEmailAreEqual() {
        AppUser user1 = new AppUser("Billy", "Bob", "b@gmail.com", "password");
        AppUser user2 = new AppUser("Anthony", "Viera", "b@gmail.com", "password");
        assertThat(user1).isEqualTo(user2);
    }

    @Test
    void shouldCheckThatUsersWithSameEmailAreDuplicatesInSet() {
        Set<AppUser> set = new HashSet<>();
        AppUser user1 = new AppUser("Anthony", "Viera", "a@gmail.com", "password");
        AppUser user2 = new AppUser("John", "Doe", "a@gmail.com", "password");
        set.add(user1);
        set.add(user2);
        assertThat(set.size()).isEqualTo(1);
    }
}