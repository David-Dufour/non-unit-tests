package com.glo4002.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.glo4002.domain.Friend;
import com.glo4002.infra.InMemoryFriendRepository;

public class FriendRepositoryIT {

    private static final Friend FRIEND1 = new Friend("Alan");
    private static final Friend FRIEND2 = new Friend("Britney");
    private static final Friend FRIEND3 = new Friend("Zyra");
    private static final List<Friend> FRIENDS = Arrays.asList(FRIEND1, FRIEND2, FRIEND3);

    private FriendRepository friendRepository;

    @BeforeEach
    public void setup() {
        friendRepository = new InMemoryFriendRepository();
    }

    @Test
    public void givenFriends_whenFindingAllFriends_thenThoseFriendsAreFound() {
        given(FRIENDS);
        List<Friend> actualFriends = friendRepository.findAllFriends();
        assertEquals(FRIENDS, actualFriends);
    }

    private void given(List<Friend> friends) {
        friends.forEach(friend -> friendRepository.save(friend));
    }
}

// 2. b) How would non-unit tests differ when testing an external database persistence?
// It's important to make sure we don't test using the real database. Otherwise, we risk corrupting data used by others.
// Some solutions consists of using an embedded database instead of a real one. It's also common to use a test container to ensure consistency.

