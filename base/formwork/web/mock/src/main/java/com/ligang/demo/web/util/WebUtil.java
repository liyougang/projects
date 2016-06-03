package com.ligang.demo.web.util;

import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

/**
 * @author liu
 *
 */
public class WebUtil {

	public static final String howbuyPrivateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDPItjytin9jS+VoeoDsO2KhhfP9xIrnxyxMkiy4oSnZIdHNBHTPzGAPwzXzyOWh52OFROGenTxrrxdoy4Mi0qx2V/OF0G/JfktBo96Ep3+LrnAcXfd2/PZUqYdjeZ9+jYOauYaXRh1I6JOiAJtsEd5fXnyGJauIDfu3V5K90MdZBl9teY4mo3E1TNN6f9O4iCe0M480s5Hzwx09HKWPkJmq6SXVsk/+7w+5tR1weSRyOdqJ2v0e4SOBZbHfK9sl38dxUwAwoRkFUzJ32y4dlKmsYQQA9VhOL8Cad7dPlZW9nW+dIZqM/L1UbV3mb4xw7wtzST/ygA50P1+O44d8drtAgMBAAECggEBAJYuoPfRhj51SIQIQmDsvj4KnWdGr2D7W1VKrRUuUZoAtGi24xm0HtLqZAhxAk+ZAm5K7744OWQmGiMWNkQYFk8+2UzW5e+Ou8yejhanOvBZtopGeu9cE8CFQTX6dZzvdpQbg7yntRzxejPQP1qCTkBS7sDOfSnA6G0DCeP2xS2f36tGAuiCUXCXiLAGeZpzWklcEElhLMAUvtcFGFnEfu5bw9BIcSI7zWHukD9E5uY3R+mPQZyZXBl5wxHWHPw7ybRorb+Oi0rPSNNUUMl4qoARJRZuTtKTv+UP4Jf8KF3zHPDy8y1Aq9vnNCqhUMxxR35BwULAGSChiOP3EHfwBUECgYEA/eWvggx2mKLtFqNGE7gFtDCKMqXBOevqFV2xw+Xj7jtJ+oOIOhhsENuNPaSOw+BYxvaRUUHVReWMDp4MRNpQxkxATlfTKexg5npPvxcXTreIqWTDCr6+vnj656o+NB6DE2q1ViMrj22L6sdJCfexuZn3q3nzrInhjKBBh45QLXECgYEA0NoEy6zWQNVVabocyrcDno7bmMwGl/edA9QKWSQKWjApccQ4fgS8iJznyBp1cS1ReI9vBEfy/1KwiSklr8XFiiqnhM+DfBmikZ+TiPxEcxSqCTFUr7a26UC9k8BSk8+Z4lL4u3avubC2VaJprEgRGDNAAVcQ5UP8pJh6QfVv9z0CgYEA3HG+jwXPOvvLKqqcv6Y5nZe/hfYQ7P9+gQqWu+Ywnrnvo4jskLR/r6tQ2MK2CjASJL4Ush6c1FFX56EmOenr1CCEfQEYIQBRqgtsjhe4buo/yAPqrLus1agpAVf5JjuPxx4RUDa9LY0JvNFHA1aCgwnB1qrN/XLB2N2Tx+SyjKECgYAsYDampCm+CtYkKdRWSj6toQMN20QHZChrmNE+EYdVlGgp8RxjwlPg3x3siZqsmol2CVv4V+VM1OAHtMN6LpaDff6sHH9+jd/Z+0MY1ykgHqLmYyHwV+1TcFsXmsSw/WpgCWsqQdSiquaDGYhEf+eJ8dHGtx4y6Jg0zOUlQKYyrQKBgC6aj13XI2ke8jGpqxa27Fax3oJiaHkO3K/paFHFrnfYVbWXwJ+hBAcU9WbBIgCV/IPYGtelq15+vpXPgrTNQBhmjgOjVyPaA5fAvUgzcs2XKDmNVa3u1YIvLZVZUiWc/U+eGe6RI3rbOaV3kGr8L2vSML7AJptW1bSMI/QbPTLC";
	public static final String howbuyPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzyLY8rYp/Y0vlaHqA7DtioYXz/cSK58csTJIsuKEp2SHRzQR0z8xgD8M188jloedjhUThnp08a68XaMuDItKsdlfzhdBvyX5LQaPehKd/i65wHF33dvz2VKmHY3mffo2DmrmGl0YdSOiTogCbbBHeX158hiWriA37t1eSvdDHWQZfbXmOJqNxNUzTen/TuIgntDOPNLOR88MdPRylj5CZqukl1bJP/u8PubUdcHkkcjnaidr9HuEjgWWx3yvbJd/HcVMAMKEZBVMyd9suHZSprGEEAPVYTi/Amne3T5WVvZ1vnSGajPy9VG1d5m+McO8Lc0k/8oAOdD9fjuOHfHa7QIDAQAB";
	public static final String merchantPrivateKey="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDglCJlKRH3Sm/yYUij8i4AhECFbkhH+/+0tcoC9BFZRKhGPNhRp6FLn38KD4gCHcsT3f1Ino43Saa2x+AlGUdBgX3+q7/eDAA0/aakVeBE64jzdI5sOCCWJSrSYiBh215XJFQz1UTLBqs92hXD2hIcjNw326R4350IrCO5cH4BhL5qYhfM2zyuZOx8/R8XD0Hju498quRS2mqmASaPXq0s56td6ryYjWuuj/JkIcj5cpZq5Pul4jsIDG0WWSBQfjdkS+DYXLZbWBBb7uSJP6sjcsENwNQH4D/lZ54X6ET25w6FQS6DSGfzMuw0Kxuu4haJHWyupGtG39dr44GxqhSZAgMBAAECggEBAIKag3ozLUiUGJBrtRPrBoe0YdV3Mj/ytF2Cjw2ypNg2TmoyflbWVr4k7nuKVr1sWCqgoej2lJxgj7yidp78mWzmAsD1XuqiLgijLqNJcdiC5a03rpAPABxxVvrsqApgyfeBoBpYv94WbcXVq2yvyHKkFHnDmV3WJXviqA/y9MSqODOguBmneump6KgrN++9ut/hqZsdL87eSq4wu4NTaFmhYYYj7e9Z9ldjSPfMTjqKc2V00yZ5MODFjFuH3UkAP6OBPUc223K8TM/gu3GBmB7l99nCyMQI+9tNiSCrlDE+s/L/Qakiq57bUJ6CBsXJAnVkPK1hW9IoEPhNxV8qvQECgYEA8CMwR8iyEEcZNWE6qFc45nGoLTZ/JqHi01vujoln8bdPQNCf+2o8lwOXLlOektu5oW4bmKC+r9BCboT39PNL1oZ0jgs6QIIuneEEJqZLgqlHY12Kx96KdZW0g0/Dos431e9STXUC1nCtzZPKDBIaGRxB4+KWnizt15r858xyj2ECgYEA72nXOVdI7wfPWa0gfhrHfRfPkuYl3T8rVzvq29z/ht2zsUALg8lvj/4D0A9t5gnjxU4WDkcu+vQKMziMKJj8nL4NDZnglWS4T7E51KluI5IS+oyWWbV7+D1FypnmQTqeg89Vh1KNnzO2H2neD117n82FpTLVztnajMKiyjJhKDkCgYB3ueOhdqOoz/n2jkJzmgEpi/NAj5I3jbEMliJLeKCVeEKQWzPYYvBQjp66n0BJkjlsDfy+TS6lc50bgzopK4BdNe44v8pMTVu2pXCvYGv3ejS4ivPdkMvRslEswwEUU+KszERpj/RZPBa7j3rGJ+RRLrB/UQKtXFM9Eu4TF/DqIQKBgBiIxCGALF0yc7FA6J+DpwXOttra8u5lVs+tuDenwhfUCGIVqhhrQB+FbGaZ7i0wvkKt6dy0tr/I2nK9TL+sTdbSMww9xKIKnEiuZLrCUiMbCQ7b8VxoGLgrr0c/1jTBCRWA3cbsUs8JwZQeiT8R2WVa7mMrfnWgJaFfIMePuh0hAoGALEdM1KsgqQar9YyBHo/dG9fafLuiVFsPzhbpK2f1D4vV3CQh5OyBIhDlYnX3u4cDvgI7xgSZLwyzqctwLuHFp9/hyAMI543eNdHCr4H179srumSizacioCn6diWgq4H1ovlbnBhNJfck0/OuN/Xlk46T3UsdECt++r8t13Ms6f8=";
	public static final String merchantPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4JQiZSkR90pv8mFIo/IuAIRAhW5IR/v/tLXKAvQRWUSoRjzYUaehS59/Cg+IAh3LE939SJ6ON0mmtsfgJRlHQYF9/qu/3gwANP2mpFXgROuI83SObDggliUq0mIgYdteVyRUM9VEywarPdoVw9oSHIzcN9ukeN+dCKwjuXB+AYS+amIXzNs8rmTsfP0fFw9B47uPfKrkUtpqpgEmj16tLOerXeq8mI1rro/yZCHI+XKWauT7peI7CAxtFlkgUH43ZEvg2Fy2W1gQW+7kiT+rI3LBDcDUB+A/5WeeF+hE9ucOhUEug0hn8zLsNCsbruIWiR1srqRrRt/Xa+OBsaoUmQIDAQAB";

	public static String getPath(HttpServletRequest request) {
		StringBuffer path = new StringBuffer();
        path.append("http://");
        path.append(request.getServerName());
       int port = request.getServerPort();
       if (port != 80) {
           path.append(":"+port);
       }
       
       path.append(request.getContextPath());
       return path.toString();
	}
	/**
	 * 得到客户的ip.
	 * @param request
	 * @return String
	 */
	public static String getCustIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		// 多级反向代理
		if (!StringUtil.isEmpty(ip)) {
			StringTokenizer st = new StringTokenizer(ip, ",");
			if (st.countTokens() > 1) {
				return st.nextToken();
			}
		}
		return ip;
	}
	/**
	 * 返回json
	 * @param response
	 * @param jsonInfo
	 * @return ModelAndView
	 */
	public static ModelAndView respJson(String jsonInfo,HttpServletResponse response) {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.print(jsonInfo);
			pw.flush();
			return null;
		} catch (Exception e) {
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
		return null;
	}
}
