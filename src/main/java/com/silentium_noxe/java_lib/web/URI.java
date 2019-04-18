package com.silentium_noxe.java_lib.web;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

import java.util.Map;

@Builder
@Getter
@Setter
public class URI {
    public static final String PATH_SEPARATOR = "/";
    public static final String PARAM_SEPARATOR = "&";
    public static final String PATH_PARAM_SEPARATOR = "?";

    private String scheme;
    private String host;
    private String port;
    private String path;

    @Singular
    private Map<String, String> params;

    @Override
    public String toString() {
        StringBuilder paramsString = new StringBuilder(PATH_PARAM_SEPARATOR);
        for(String key : params.keySet()){
            paramsString.append(key).append("=").append(params.get(key)).append(PARAM_SEPARATOR);
        }
        paramsString.deleteCharAt(paramsString.length()-1);

        if (port != null && !port.isEmpty()){
            port = ":"+port;
        }

        if (path != null && !path.isEmpty()){
            if (path.indexOf("/") == 0){
                path = path.substring(1);
            }
        }

        return scheme+"://"+host+port+PATH_SEPARATOR+path+paramsString.toString();
    }
}
