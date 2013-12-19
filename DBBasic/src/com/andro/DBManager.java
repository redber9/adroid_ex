package com.andro;

import android.content.Context;
import android.database.sqlite.*;

public class DBManager extends SQLiteOpenHelper {

	// DBManager Ŭ������ ��ü�� ������� �� �����(������)
	public DBManager(Context context) {
		// DB�� ������(�̹� ������ ���� �������� ����)
		super(context, "myDB", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// ���̺��� ������(�̹� ������ ���� �������� ����)
		db.execSQL("create table customers (name text, sex text, sms text);");
	}
	
	// �����ϴ� DB�� ������ �ٸ� ���
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
}