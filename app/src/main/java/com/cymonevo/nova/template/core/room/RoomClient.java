package com.cymonevo.nova.template.core.room;

import android.content.Context;

import androidx.room.Room;

import com.cymonevo.nova.template.service.db.SqliteDB;

public class RoomClient {
    private SqliteDB db;

    public RoomClient(Context context, String dbName) {
        db = Room.databaseBuilder(context, SqliteDB.class, dbName).build();
    }

    public SqliteDB getInstance() {
        return this.db;
    }
}
