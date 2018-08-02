package com.owen.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

;


/**
 * @Description： 日志filter
 * Created by huang_b on 2017/7/19.
 */
@Component
public class AmbitorRequestLoggingFilter extends AbstractRequestLoggingFilter {

    private ApplicationContext applicationContext;
    private static Logger logger = LoggerFactory.getLogger(AmbitorRequestLoggingFilter.class);

    public AmbitorRequestLoggingFilter() {
        setIncludePayload(true);
        setIncludeQueryString(true);
        setMaxPayloadLength(5000);
        setIncludeClientInfo(true);
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {

        startTime.set(System.currentTimeMillis());
        logger.info("请求开始-----" + message.replaceAll("\r|\n| ", "") + "------");

    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        String traceId = (String) request.getAttribute("traceId");
        logger.info("traceId:" + traceId + "   请求结束----" + message.replaceAll("\r|\n| ", "") + "------耗时:" + (System.currentTimeMillis() - startTime.get()));
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        super.doFilterInternal(request, response, filterChain);
        if (isNotBinaryOutput(request) && !isAsyncDispatch(request) && !(response instanceof ContentCachingResponseWrapper)) {
            response = new ContentCachingResponseWrapper(response);
        }


        String traceId = (String) request.getAttribute("traceId");
        if (!isBinaryContent(response.getContentType())) {
            StringBuilder msgBuilder = new StringBuilder("返回信息----traceId:"+traceId);
            msgBuilder.append("content-type=").append(response.getContentType()).append("; ").append("body=")
                    .append(getResponsePayload(response)).append("------");
            logger.info(msgBuilder.toString());


        }
    }

    private String getResponsePayload(HttpServletResponse response) {
        String payload = null;
        if (!(response instanceof ContentCachingResponseWrapper)) {
            return payload;
        }
        ContentCachingResponseWrapper wrapper = (ContentCachingResponseWrapper) response;
        if (wrapper != null) {
            byte[] buff = wrapper.getContentAsByteArray();
            if (buff.length > 0) {
                try {
                    payload = new String(buff, response.getCharacterEncoding());
                    wrapper.copyBodyToResponse();
                } catch (IOException e) {
                    logger.warn("failed to get response payload", e);
                }
            }
        }
        return payload;
    }

    private boolean isBinaryContent(String contentType) {
        if (contentType == null) {
            return false;
        }
        return contentType.contains("image") || contentType.contains("video") || contentType.contains("audio")
                || contentType.contains("application/octet-stream") || contentType.contains("multipart/form-data");
    }

    private boolean isNotBinaryOutput(HttpServletRequest request) {
        String uri = request.getRequestURI().toLowerCase();
        if (uri.startsWith("/charge_manage/active/selectActive")) {
            return false;
        }
        String method = uri.substring(uri.lastIndexOf('/'));
        if (method.contains("export") || method.contains("download")) {
            return false;
        }
        return true;
    }

    private ThreadLocal<Long> startTime = new ThreadLocal<>();


}
