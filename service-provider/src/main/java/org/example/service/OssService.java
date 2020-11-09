package org.example.service;

import org.example.dto.OssCallbackResult;
import org.example.dto.OssPolicyResult;

/**
 * oss上传管理Service
 * Created  on 2020/8/25.
 */
import javax.servlet.http.HttpServletRequest;

public interface OssService {
    /**
     * oss上传策略生成
     */
    OssPolicyResult policy();
    /**
     * oss上传成功回调
     */
    OssCallbackResult callback(HttpServletRequest request);
}
