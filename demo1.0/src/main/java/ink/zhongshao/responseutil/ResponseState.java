package ink.zhongshao.responseutil;

/**
 * 自定义响应状态
 * 
 * @author wangfan
 * @version 2.1
 */
public enum ResponseState {

	SUCCESS(200, "操作成功", ""), ERROR(500, "服务器忙,请稍后重试", "");

	private Integer code;
	private String message;
	private String remark;

	private ResponseState(Integer code, String message, String remark) {
		this.code = code;
		this.message = message;
		this.remark = remark;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getRemark() {
		return remark;
	}

}
