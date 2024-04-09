package pojo.valueobject;
/**消息模型对象 (数据响应)
    状态码
        1=成功，0=失败
    提示信息
        字符串(成功或失败）
    回显数据
        object对象
**/
public class MessageModel {
    private Integer code = 1;
    private String message = "成功！";
    private Object object;

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

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}
