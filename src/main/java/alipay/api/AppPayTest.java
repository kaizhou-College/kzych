package alipay.api;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;

public class AppPayTest {

	public static String serverUrl = "https://openfile.alipay.com/chat/multimedia.do";
	public static String APP_ID = "2016102100728313";
	public static String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCKQ2pEIzXM4IoN1cMzOFXdlk8yVX2cKXWITZ92EGAQQcRytaV07yQOaz3UE9KTeT9Nu628G+HZMsJUxQjEUETagmY5nLtbeL35M2UcibYpM3e2gVTtUW86CA65GCdLzUhdIug8yf2F9zWayzG4sHZ9DcTezG6ZjFu+EtDpFgg+CtqY7n/ihjTIqeE1lX0C2ZIKpIYs7QjR8AztB/qRcpOJKRfMKGDgmT9GALN8LeFEYCbQ+W/GJHN8bQ0Bk1Ll6EKQ4cHXZ1Yko+aXaRfbXfUZYgD9hwAVlxtwZndgeFX8KapOCw0J25pzV4WkutIjMlt7I2Q1jaWNoKLuxtz4M2mzAgMBAAECggEAAhnsL4TpeGehMXyiLtEYXPm/0mACPLFUm/GyDrVJAHY/ag7gqNpJjf6LPgHfHWamU6Qai9VQpWBkG62y6Gjf4wJAU3fSUR2QpYzmaHyfTBkAJMHqbIDkU9lzf9SiJEDGbMPvC512QOb05ZlY9Bmac2QWLdylgafkbQsUKbawAWFa/BAOMIp0tgYLW8/yY2aG6jeLqhOgTo8MWIW5d1qHtX5m/x7g97dYYMdX3kTo2i1dFLUVfEOvZe4US6VBvLg71dMxwadVF5YMaY9jq/ShPD0Gkf29wdThwsjcH6u9Tq/KArQTK+z02DAGkdWOcue3pHql+gvoIA8U5uFDdIeYwQKBgQDri3jPkDKi48efdKQk38rn+CJYeNFNRAhlly3h2AHaFEY92XRlBsho/vGFg43BvHu+cMz0Run4SS8Vo09vcTIY6p2xNMffjR0w2gQqx6PUdGHBFtw7FavxN4uVtVhL6uTAqfBv97mqQO0bq+DhOGwSRNIWqvnzfXywqwmXhKYECwKBgQCWRTl6tNv8scxPq4fpRL/uw71TU6XqSS/nME7KT4uyQPAXPk0mXVVwdmyST9Crlr6O6WJopPe9nMIFUYdjdkLfGKLCR96AH3U7frr4jf60eDYEhfHGIzln/ptrTJLvvbXTaPctAaZd6TIv63QVz3yim4MMl3VSdRlrE+O9R5ZR+QKBgQDjEP8TyUSnNsJX+4/JZFwsp04kz8OlorIdjVHT5/JREz5rnVfRlGpanXqjZSCg5Vy9R+ysiDhA+/wB9f87xXmv/2ypSeJspZLAZ0uhGffbdZ5PEASaiNfKn+tWFQ3bkcOX37tDlSJM+G4bQOR2+XdlXSbSZ1yx2AT+IsQKZvvL5QKBgQCPZEUiEz0sV1kX2R2a+XCQ3RVnUxWqh+X/HPjCUr+B/DdeZqPl7QAfjdGymBkN842o/4lZQ7nnpJL70j14KpxLGM4Ox9fIuLv8ZsTxc0XOXjtle48nO+uGkc0qyWoY/RVpQ+tBdiaTzHeIhIxEV7adz/lwZYKdiYIUzGjv8ES/uQKBgCgeWysXjahCQItxx5fTrS8SQFP7Dx5vDW+UkqQ2pbL0AlHyUS7pWJj3AAe3pn4AJZZp4SZPoQP+Z8JPqDA6MrQWHYMi0XkMuMYwLWbGCkmf1MnjUxgOaLXoItjxS/y3jQfeOmHhmOAVkjnEvAh+BWlZxFMv2kiuHRU72bNa0rDI";
	public static String format = "json";
	public static String charset = "utf-8";
	public static final String ALIPAY_PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAikNqRCM1zOCKDdXDMzhV3ZZPMlV9nCl1iE2fdhBgEEHEcrWldO8kDms91BPSk3k/TbutvBvh2TLCVMUIxFBE2oJmOZy7W3i9+TNlHIm2KTN3toFU7VFvOggOuRgnS81IXSLoPMn9hfc1mssxuLB2fQ3E3sxumYxbvhLQ6RYIPgramO5/4oY0yKnhNZV9AtmSCqSGLO0I0fAM7Qf6kXKTiSkXzChg4Jk/RgCzfC3hRGAm0PlvxiRzfG0NAZNS5ehCkOHB12dWJKPml2kX2131GWIA/YcAFZcbcGZ3YHhV/CmqTgsNCduac1eFpLrSIzJbeyNkNY2ljaCi7sbc+DNpswIDAQAB";
	public static void main(String[] args) {
		// 实例化客户端
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", APP_ID,
				APP_PRIVATE_KEY, "json", charset, ALIPAY_PUBLIC_KEY, "RSA2");
		// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
		// SDK已经封装掉了公共参数，这里只需要传入业务参数。
		//以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setBody("我是测试数据");
		model.setSubject("App支付测试Java");
		model.setOutTradeNo("201818181");
		model.setTimeoutExpress("30m");
		model.setTotalAmount("0.01");
		model.setProductCode("QUICK_MSECURITY_PAY");
		request.setBizModel(model);
		//request.setNotifyUrl("商户外网可以访问的异步地 址");
		try {
			// 这里和普通的接口调用不同，使用的是sdkExecute
			AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
			System.out.println(response.getBody());// 就是orderString
													// 可以直接给客户端请求，无需再做处理。
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
	}
}
