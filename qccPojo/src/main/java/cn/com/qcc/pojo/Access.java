package cn.com.qcc.pojo;

public class Access  implements Comparable<Access>{
    /** 权限主键*/
    private Long accessid;

    /** 权限名称*/
    private String accessname;

    /** 权限地址*/
    private String accessurl;
    
    private Integer type ;
    
    public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getAccessid() {
        return accessid;
    }

    public void setAccessid(Long accessid) {
        this.accessid = accessid;
    }

    public String getAccessname() {
        return accessname;
    }

    public void setAccessname(String accessname) {
        this.accessname = accessname == null ? null : accessname.trim();
    }

    public String getAccessurl() {
        return accessurl;
    }

    public void setAccessurl(String accessurl) {
        this.accessurl = accessurl == null ? null : accessurl.trim();
    }

	@Override
	public int compareTo(Access o) {
		int  i = Integer.parseInt((this.getAccessid() - o.getAccessid() )+"") ;//先按照年龄排序
		if(i == 0){
			return  i;//如果年龄相等了再用分数进行排序
		}
		return i;

	}
}