package cn.com.qcc.queryvo;

import java.util.List;

import cn.com.qcc.pojo.Maillist;


public class MailCustomer extends Maillist {
	
	
	private String avatar;
	
	private String fansMess;
	
	private String fansState;
	
	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getFansMess() {
		return fansMess;
	}

	public void setFansMess(String fansMess) {
		this.fansMess = fansMess;
	}

	public String getFansState() {
		return fansState;
	}

	public void setFansState(String fansState) {
		this.fansState = fansState;
	}

	private List<Maillist> mails;

	public List<Maillist> getMails() {
		return mails;
	}

	public void setMails(List<Maillist> mails) {
		this.mails = mails;
	}
	
	

}
