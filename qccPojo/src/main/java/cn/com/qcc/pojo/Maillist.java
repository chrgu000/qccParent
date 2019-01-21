package cn.com.qcc.pojo;

public class Maillist {
    /** */
    private Long userid;

    /** 名称*/
    private String displayName;

    /** 电话号码*/
    private String phoneNumbers;
  
    


	public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers == null ? null : phoneNumbers.trim();
    }
}