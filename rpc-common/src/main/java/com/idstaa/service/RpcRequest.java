package com.idstaa.service;

import java.util.Arrays;

/**
 * @author chenjie
 * @date 2020/12/19 16:31
 */
public class RpcRequest {
    /**
     * 请求对象的id
     */
    private String requestId;
    /**
     * 类名
     */
    private String className;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 参数类型
     */
    private Class<?>[] parameterTypes;

    /**
     * 入参
     */
    private Object[] parameters;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"requestId\":\"")
                .append(requestId).append('\"');
        sb.append(",\"className\":\"")
                .append(className).append('\"');
        sb.append(",\"methodName\":\"")
                .append(methodName).append('\"');
        sb.append(",\"parameterTypes\":")
                .append(Arrays.toString(parameterTypes));
        sb.append(",\"parameters\":")
                .append(Arrays.toString(parameters));
        sb.append('}');
        return sb.toString();
    }
}
