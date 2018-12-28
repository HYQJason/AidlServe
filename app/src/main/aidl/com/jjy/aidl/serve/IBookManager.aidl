// IBookManager.aidl
package com.jjy.aidl.serve;

// Declare any non-default types here with import statements
import com.jjy.aidl.serve.Book;

/**
* 参数修饰符
  in: 表示参数数据只能由客户端传递到服务端，基本类型就默认只支持in修饰符。
  out：表示参数数据只能由服务端传递到客户端。即服务端如果修改了参数对象的值，那么客户端的值也会变化，但是服务端无法读取到客户端对象的值。
  inout：表示参数数据能够双向传递。
* */
interface IBookManager {


    /**
        * 获取图书列表
        */
       List<Book> getBookList();

       /**
        * 添加图书
        */
       void addBook(in Book book);
}
