package com.idstaa.service;

/**
 * @author chenjie
 * @date 2020/12/19 16:35
 */
public class RpcResponse {
    /**
     * 响应ID
     */
    private String requestId;
    /**
     * 错误信息
     */
    private String error;
    /**
     * 返回的结果
     */
    private Object object;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"requestId\":\"")
                .append(requestId).append('\"');
        sb.append(",\"error\":\"")
                .append(error).append('\"');
        sb.append(",\"object\":")
                .append(object);
        sb.append('}');
        return sb.toString();
    }
}
