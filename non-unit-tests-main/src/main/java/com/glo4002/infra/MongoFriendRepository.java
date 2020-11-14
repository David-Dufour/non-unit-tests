package com.glo4002.infra;

import java.util.List;

import com.glo4002.domain.Friend;
import com.glo4002.service.FriendRepository;

public class MongoFriendRepository implements FriendRepository {

    @Override
    public void save(Friend friend) {

    }

    @Override
    public List<Friend> findAllFriends() {
        return null;
    }
}
