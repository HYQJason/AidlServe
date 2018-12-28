package com.jjy.aidl.serve;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
public class AIDLService extends Service {
    private List<Book> bookList;
    @Override
    public void onCreate() {
        super.onCreate();
        bookList = new ArrayList<>();
        initData();
    }
    private void initData() {
        bookList.add(new Book("码出高效：Java开发"));
        bookList.add(new Book("架构整洁之道"));
        bookList.add(new Book("Spring Cloud微服"));
        bookList.add(new Book("Android App开发从"));
        bookList.add(new Book("Android音视频开发"));
    }
    private final IBookManager.Stub stub = new IBookManager.Stub() {
        @Override
        public List<Book> getBookList() throws RemoteException {
            return bookList;
        }
        @Override
        public void addBook(Book book) throws RemoteException {
            bookList.add(book);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }
}
