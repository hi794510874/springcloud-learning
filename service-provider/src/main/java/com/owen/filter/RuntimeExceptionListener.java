package com.owen.filter;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description： 运行时异常监听，在运行时异常发生后，进行一些操作
 * Created by huang_b on 2017/7/19.
 */
public interface RuntimeExceptionListener {

    void runtimeExceptionEvent(HttpServletRequest request, RuntimeException runtimeException);
}
