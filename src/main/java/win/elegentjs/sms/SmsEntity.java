package win.elegentjs.sms;

/**
 * 短信实体
 */
public class SmsEntity {

    private String returnsms;
    // 返回状态（Success, Fail）
    private String returnstatus;

    private String message;
    // 返回余额
    private String remainpoint;
    // 本次任务的序列ID
    private String taskID;
    // 成功短信数
    private String successCounts;
    // 付费方式（预付费，后付费）
    private String payinfo;
    // 已发送短信数
    private String overage;
    // 总点数，支付方式为预付费时返回总充值点数
    private String sendTotal;


    private String statusbox;
    // 手机号
    private String mobile;
    // 发送状态（10：发送成功；20：发送失败）
    private String status;
    // 接收时间
    private String receivetime;



    private String errorstatus;
    // 错误码
    private String error;
    // 错误描述
    private String remark;


    private String callbox;
    // 任务ID
    private String taskid;
    // 短信内容
    private String content;

    public String getReturnsms() {
        return returnsms;
    }

    public void setReturnsms(String returnsms) {
        this.returnsms = returnsms;
    }

    public String getReturnstatus() {
        return returnstatus;
    }

    public void setReturnstatus(String returnstatus) {
        this.returnstatus = returnstatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRemainpoint() {
        return remainpoint;
    }

    public void setRemainpoint(String remainpoint) {
        this.remainpoint = remainpoint;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getSuccessCounts() {
        return successCounts;
    }

    public void setSuccessCounts(String successCounts) {
        this.successCounts = successCounts;
    }

    public String getPayinfo() {
        return payinfo;
    }

    public void setPayinfo(String payinfo) {
        this.payinfo = payinfo;
    }

    public String getOverage() {
        return overage;
    }

    public void setOverage(String overage) {
        this.overage = overage;
    }

    public String getSendTotal() {
        return sendTotal;
    }

    public void setSendTotal(String sendTotal) {
        this.sendTotal = sendTotal;
    }

    public String getStatusbox() {
        return statusbox;
    }

    public void setStatusbox(String statusbox) {
        this.statusbox = statusbox;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceivetime() {
        return receivetime;
    }

    public void setReceivetime(String receivetime) {
        this.receivetime = receivetime;
    }

    public String getErrorstatus() {
        return errorstatus;
    }

    public void setErrorstatus(String errorstatus) {
        this.errorstatus = errorstatus;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCallbox() {
        return callbox;
    }

    public void setCallbox(String callbox) {
        this.callbox = callbox;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
