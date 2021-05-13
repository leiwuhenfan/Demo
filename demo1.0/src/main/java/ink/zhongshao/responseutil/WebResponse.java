package ink.zhongshao.responseutil;

/**
 * 返回数据统一实体
 * 
 * @author wangfan
 *
 */
public class WebResponse<T> {

	private Integer code;

	private String message;

	private T data;

	private String splitChar;// 用于前端拆分提示信息message的字符(批量操作，部分成功部分失败时候使用)

	// -----构造方法-----

	public WebResponse() {
		// 默认构造函数,接口调用对象装换需要
	}

	private WebResponse(Integer code) {
		super();
		this.code = code;
	}

	private WebResponse(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	// ----------------生成相应参数对象----------------
	/**
	 * 创建的对象默认为失败对象
	 * 
	 * @return
	 */
	public static <T> WebResponse<T> newInstance() {

		// 默认失败代码
		return new WebResponse<>(ResponseState.ERROR.getCode(), ResponseState.ERROR.getMessage());
	}

	public static <T> WebResponse<T> newInstance(Integer code) {

		// 指定代码
		return new WebResponse<>(code);
	}

	public static <T> WebResponse<T> newInstance(Integer code, String message) {

		// 指定代码和提示消息
		return new WebResponse<>(code, message);
	}

	
	public static <T> WebResponse<T> newInstance(Integer code, T t) {
		WebResponse<T> res = WebResponse.<T> newInstance(code);
		res.setData(t);
		return res;
	}

	public static <T> WebResponse<T> newInstance(Integer code, String messge, T t) {
		WebResponse<T> res = WebResponse.<T> newInstance(code, messge);
		res.setData(t);
		return res;
	}

	// -------------------------------成功对象-------------------------------

	public static <T> WebResponse<T> success() {
		return WebResponse.<T> newInstance(ResponseState.SUCCESS.getCode(), ResponseState.SUCCESS.getMessage());
	}

	public static <T> WebResponse<T> success(String message) {
		return WebResponse.<T> newInstance(ResponseState.SUCCESS.getCode(), message);
	}

	public static <T> WebResponse<T> success(T t) {
		return WebResponse.<T> newInstance(ResponseState.SUCCESS.getCode(), ResponseState.SUCCESS.getMessage(), t);
	}

	public static <T> WebResponse<T> success(String message, T t) {
		if (null == message || message.length() == 0) {
			return WebResponse.<T> newInstance(ResponseState.SUCCESS.getCode(), ResponseState.SUCCESS.getMessage(), t);
		}
		return WebResponse.<T> newInstance(ResponseState.SUCCESS.getCode(), message, t);
	}

	public static <T> WebResponse<T> newSuccessInstance(T t) {
		return newInstance(ResponseState.SUCCESS.getCode(), ResponseState.SUCCESS.getMessage(), t);
	}

	// -------------------------------错误对象-------------------------------
	public static <T> WebResponse<T> error() {
		return WebResponse.<T> newInstance(ResponseState.ERROR.getCode(), ResponseState.ERROR.getMessage());
	}

	public static <T> WebResponse<T> error(String error) {
		return WebResponse.<T> newInstance(ResponseState.ERROR.getCode(), error);
	}

	public boolean isSuccess(int code) {

		return (ResponseState.SUCCESS.getCode() == code);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getSplitChar() {
		return splitChar;
	}

	public void setSplitChar(String splitChar) {
		this.splitChar = splitChar;
	}

	@Override
	public String toString() {
		return "WebResponse [code=" + code + ", message=" + message + ", data=" + data + ", splitChar=" + splitChar
				+ "]";
	}

}
