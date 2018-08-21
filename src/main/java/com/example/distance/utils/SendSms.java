package com.example.distance.utils;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
@ConfigurationProperties(prefix = "alisms")
public class SendSms {

    private static String product ;//短信API产品名称（短信产品名固定，无需修改）
    private static String domain ;//短信API产品域名（接口地址固定，无需修改）

    private static String accessKeyId;
    private static String accessKeySecret;
    private static String signName;
    private static String templateCode;

    @Value("${alisms.product}")
    public void setProduct(String pro) {
        product = pro;
    }
    @Value("${alisms.domain}")
    public void setDomain(String dom) {
        domain = dom;
    }

    @Value("${alisms.accessKeyId}")
    public void setAccessKeyId(String KeyId) {
        accessKeyId = KeyId;
    }

    @Value("${alisms.accessKeySecre")
    public void setAccessKeySecret(String secret) {
        accessKeySecret = secret;
    }

    @Value("${alisms.signName")
    public void setSignName(String sign) {
        signName = sign;
    }

    @Value("${alisms.accessKeySecre")
    public void setTemplateCode(String temp) {
        templateCode = temp;
    }


    public static boolean send(String phoneNumbers, String code) {

        try {
            //设置超时时间-可自行调整
            System.setProperty("sun.net.client.defaultConnectTimeout", "20000");
            System.setProperty("sun.net.client.defaultReadTimeout", "20000");
            //初始化ascClient需要的几个参数

            //初始化ascClient,暂时不支持多region（请勿修改）
            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                    accessKeySecret);
            try {
                DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
            } catch (ClientException e1) {
                e1.printStackTrace();
                return false;
            }
            IAcsClient acsClient = new DefaultAcsClient(profile);
            //组装请求对象
            SendSmsRequest request = new SendSmsRequest();
            //使用post提交
            request.setMethod(MethodType.POST);
            //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为00+国际区号+号码，如“0085200000000”
            request.setPhoneNumbers(phoneNumbers);
            //必填:短信签名-可在短信控制台中找到
            request.setSignName(signName);
            //必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
            request.setTemplateCode(templateCode);
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
            String param = "{\"code\":\"" + code + "\"}";

            request.setTemplateParam(param);

            //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
            //request.setSmsUpExtendCode("90997");
            //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
            request.setOutId("yourOutId");
            //请求失败这里会抛ClientException异常
            SendSmsResponse sendSmsResponse = null;
            try {
                sendSmsResponse = acsClient.getAcsResponse(request);
            } catch (ClientException e1) {
                e1.printStackTrace();
            }
            if (sendSmsResponse.getCode() != null) {
                if (sendSmsResponse.getCode().equals("OK")) {
                    //请求成功
                    return true;

                } else {
                    System.out.println("短信码" + sendSmsResponse.getCode());
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
